package no.ntnu.library.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

import no.ntnu.library.model.Book;

public interface BookRepository {

  @Transactional(readOnly = true)
  List<Book> findBooks();
  
  @Transactional(readOnly = true)
  Optional<Book> findBookById(long bookId);
  
  @Transactional
  Book createBook(String title, int year, int pages);
  
  @Transactional
  Book updateBook(long bookId, String title, int year, int pages);
  
  @Transactional
  void deleteBook(long bookId);

}
