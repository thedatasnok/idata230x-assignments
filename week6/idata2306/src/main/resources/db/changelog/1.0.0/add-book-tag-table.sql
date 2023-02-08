CREATE TABLE book_tag (
  book_tag_id BIGINT GENERATED ALWAYS AS IDENTITY,
  fk_book_id BIGINT NOT NULL,
  tag TEXT NOT NULL,

  PRIMARY KEY (book_tag_id),
  FOREIGN KEY (fk_book_id) REFERENCES book(book_id)
);