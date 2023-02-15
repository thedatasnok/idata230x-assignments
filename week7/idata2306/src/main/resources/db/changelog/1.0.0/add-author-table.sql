CREATE TABLE author (
  author_id BIGINT GENERATED ALWAYS AS IDENTITY,
  first_name TEXT,
  last_name TEXT,
  year_of_birth INTEGER,

  PRIMARY KEY(author_id)
);
