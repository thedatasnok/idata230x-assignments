package no.ntnu.library.repository;

import org.springframework.data.repository.CrudRepository;

import no.ntnu.library.model.Book;

public interface BookRepository extends CrudRepository<Book, Long> {}
