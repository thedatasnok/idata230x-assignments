-- Insert 10 authors

INSERT INTO author (first_name, last_name, year_of_birth) VALUES
('John', 'Doe', 1980),
('Jane', 'Doe', 1985),
('John', 'Smith', 1970),
('Jane', 'Smith', 1975),
('John', 'Doe', 1960),
('Jane', 'Doe', 1965),
('John', 'Smith', 1950),
('Jane', 'Smith', 1955),
('John', 'Doe', 1940),
('Jane', 'Doe', 1945);

-- Insert 10 books

INSERT INTO book (title, year_published, pages) VALUES
('Book 1', 2010, 100),
('Book 2', 2011, 200),
('Book 3', 2012, 300),
('Book 4', 2013, 400),
('Book 5', 2014, 500),
('Book 6', 2015, 600),
('Book 7', 2016, 700),
('Book 8', 2017, 800),
('Book 9', 2018, 900),
('Book 10', 2019, 1000);

-- Insert some book authors

INSERT INTO book_author (fk_book_id, fk_author_id) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 6),
(7, 7),
(8, 8),
(9, 9),
(10, 10);

-- Insert some book tags

INSERT INTO book_tag (fk_book_id, tag_name) VALUES
(1, 'tag1'),
(2, 'tag2'),
(3, 'tag3'),
(4, 'tag4'),
(5, 'tag5'),
(6, 'tag6'),
(7, 'tag7'),
(8, 'tag8'),
(9, 'tag9'),
(10, 'tag10');
