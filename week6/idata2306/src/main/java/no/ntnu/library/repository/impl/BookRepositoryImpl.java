package no.ntnu.library.repository.impl;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import no.ntnu.library.model.Book;
import no.ntnu.library.repository.BookRepository;

@Repository
@RequiredArgsConstructor  
class BookRepositoryImpl implements BookRepository {
  private final JdbcTemplate jdbcTemplate;

  private static final RowMapper<Book> BOOK_MAPPER = (rs, rowNum) -> new Book(
      rs.getLong("book_id"),
      rs.getString("title"),
      rs.getInt("year_published"),
      rs.getInt("pages")
  );

  private Book findById(long bookId) {
    return this.jdbcTemplate.queryForObject(
      "SELECT * FROM book WHERE book_id = ?",
      BOOK_MAPPER,
      bookId
    );
  }

  @Override
  public List<Book> findBooks() {
    return this.jdbcTemplate.query("SELECT * FROM book", BOOK_MAPPER);
  }

  @Override
  public Optional<Book> findBookById(long bookId) {
    return Optional.ofNullable(this.findById(bookId));
  }

  @Override
  public Book createBook(String title, int year, int pages) {
    var bookId = new SimpleJdbcInsert(this.jdbcTemplate)
      .withTableName("book")
      .usingGeneratedKeyColumns("book_id")
      .executeAndReturnKey(
        Map.of(
          "title", title,
          "year_published", year,
          "pages", pages
        )
      )
      .longValue();

    return this.findById(bookId);
  }

  @Override
  public Book updateBook(long bookId, String title, int year, int pages) {
    this.jdbcTemplate.update(
      "UPDATE book SET title = ?, year_published = ?, pages = ? WHERE book_id = ?",
      title,
      year,
      pages,
      bookId
    );

    return this.findById(bookId);
  }

  @Override
  public void deleteBook(long bookId) {
    this.jdbcTemplate.update(
      "DELETE FROM book WHERE book_id = ?",
      bookId
    );
  }

}
