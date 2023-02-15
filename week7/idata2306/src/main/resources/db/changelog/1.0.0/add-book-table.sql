CREATE TABLE book (
  book_id BIGINT GENERATED ALWAYS AS IDENTITY,
  title TEXT,
  year_published INTEGER,
  pages INTEGER,

  PRIMARY KEY (book_id)
);