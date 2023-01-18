package no.ntnu.hello.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import no.ntnu.hello.dto.CreateBookRequest;
import no.ntnu.hello.dto.UpdateBookRequest;
import no.ntnu.hello.model.Book;

@RestController
@RequestMapping("/books")
public class BookController {
  private List<Book> books;

  public BookController() {
    this.books = new ArrayList<>();
    this.books.add(new Book(1, "The Lord of the Rings", 1954, 1216));
    this.books.add(new Book(2, "The Hobbit", 1937, 310));
    this.books.add(new Book(3, "The Silmarillion", 1977, 429));
    this.books.add(new Book(4, "The Children of Húrin", 2007, 352));
    this.books.add(new Book(5, "The Fall of Gondolin", 2018, 352));
    this.books.add(new Book(6, "Unfinished Tales", 1980, 416)); 
    this.books.add(new Book(7, "The History of Middle-earth", 1983, 1440));
    this.books.add(new Book(8, "The Book of Lost Tales", 1984, 416));
    this.books.add(new Book(9, "The Book of Lost Tales Part Two", 1984, 416));
    this.books.add(new Book(10, "The Lays of Beleriand", 1985, 416));
  }

  private Optional<Book> getLastBook() {
    if (this.books.isEmpty()) return Optional.empty();

    return Optional.of(this.books.get(this.books.size() - 1));
  }

  @GetMapping
  public ResponseEntity<List<Book>> listBooks() {
    return ResponseEntity.ok(this.books);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Book> findBook(@PathVariable int id) {
    var foundBook = this.books.stream()
      .filter(book -> book.id() == id)
      .findFirst();

    if (foundBook.isEmpty()) return ResponseEntity.notFound().build();

    return ResponseEntity.ok(foundBook.get());
  }

  @PostMapping
  public ResponseEntity<Book> createBook(@RequestBody CreateBookRequest book) {
    if (book.title() == null) return ResponseEntity.badRequest().build();
    
    var lastBook = this.getLastBook();
    var newBookId = lastBook.isPresent() ? lastBook.get().id() + 1 : 1;
    var newBook = new Book(newBookId, book.title(), book.year(), book.numberOfPages());

    this.books.add(newBook);
    
    return ResponseEntity.created(URI.create("/books/" + newBook.id())).body(newBook);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Book> updateBook(
      @PathVariable int id, 
      @RequestBody UpdateBookRequest book
  ) {
    boolean oldBookRemoved = this.books.removeIf(oldBook -> oldBook.id() == id);
    
    if (!oldBookRemoved) return ResponseEntity.notFound().build();
    
    var updatedBook = new Book(id, book.title(), book.year(), book.numberOfPages());
    this.books.add(updatedBook);

    return ResponseEntity.ok(updatedBook);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Object> deleteBook(@PathVariable int id) {
    boolean bookRemoved = this.books.removeIf(book -> book.id() == id);

    if (!bookRemoved) return ResponseEntity.notFound().build();

    return ResponseEntity.noContent().build();
  }

}
