CREATE TABLE book (
  book_id BIGINT GENERATED ALWAYS AS IDENTITY,
  title TEXT,
  year_published INTEGER,
  pages INTEGER,
  fk_author_id BIGINT,

  PRIMARY KEY (book_id),
  FOREIGN KEY (fk_author_id) REFERENCES author(author_id)
);