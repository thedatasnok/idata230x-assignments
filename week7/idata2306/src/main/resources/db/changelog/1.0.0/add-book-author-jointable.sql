CREATE TABLE book_author (
  fk_book_id BIGINT NOT NULL,
  fk_author_id BIGINT NOT NULL,

  PRIMARY KEY (fk_book_id, fk_author_id),
  FOREIGN KEY (fk_book_id) REFERENCES book (book_id),
  FOREIGN KEY (fk_author_id) REFERENCES author (author_id)
);