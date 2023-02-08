package no.ntnu.library.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import no.ntnu.library.dto.CreateBookRequest;
import no.ntnu.library.dto.UpdateBookRequest;
import no.ntnu.library.exception.model.NotFoundException;
import no.ntnu.library.model.Book;
import no.ntnu.library.repository.BookRepository;

@Tag(
  name = "Books collection",
  description = "Operations on a collection of books"
)
@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {
  private final BookRepository bookRepository;

  private static final String BOOK_NOT_FOUND_MESSAGE = "Could not find a book with id: ";

  @Operation(summary = "Lists all books in the collection")
  @GetMapping
  public ResponseEntity<List<Book>> listBooks() {
    return ResponseEntity.ok(this.bookRepository.findBooks());
  }

  @Operation(summary = "Finds a book by its ID")
  @GetMapping("/{id}")
  public ResponseEntity<Book> findBook(@PathVariable long id) {
    var foundBook = this.bookRepository.findBookById(id);

    if (foundBook.isEmpty()) throw new NotFoundException(BOOK_NOT_FOUND_MESSAGE + id);

    return ResponseEntity.ok(foundBook.get());
  }

  @Operation(summary = "Creates a new book and stores it in the collection")
  @PostMapping
  public ResponseEntity<Book> createBook(@RequestBody CreateBookRequest book) {
    if (book.title() == null) return ResponseEntity.badRequest().build();
    
    var createdBook = this.bookRepository.createBook(book.title(), book.year(), book.numberOfPages());

    return ResponseEntity.created(URI.create("/books/" + createdBook.id())).body(createdBook);
  }

  @Operation(summary = "Updates an existing book by its ID")
  @PutMapping("/{id}")
  public ResponseEntity<Book> updateBook(
      @PathVariable int id, 
      @RequestBody UpdateBookRequest book
  ) {
    var updatedBook = this.bookRepository.updateBook(id, book.title(), book.year(), book.numberOfPages());

    return ResponseEntity.ok(updatedBook);
  }

  @Operation(summary = "Deletes a book by its ID")
  @DeleteMapping("/{id}")
  public ResponseEntity<Object> deleteBook(@PathVariable int id) {
    var bookExists = this.bookRepository.findBookById(id).isPresent();

    if (!bookExists) throw new NotFoundException(BOOK_NOT_FOUND_MESSAGE + id);

    this.bookRepository.deleteBook(id);

    return ResponseEntity.noContent().build();
  }

}
