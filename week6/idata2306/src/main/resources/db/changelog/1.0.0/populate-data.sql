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

INSERT INTO book (title, year_published, pages, fk_author_id) VALUES
('Book 1', 2010, 100, 1),
('Book 2', 2011, 200, 2),
('Book 3', 2012, 300, 3),
('Book 4', 2013, 400, 4),
('Book 5', 2014, 500, 5),
('Book 6', 2015, 600, 6),
('Book 7', 2016, 700, 7),
('Book 8', 2017, 800, 8),
('Book 9', 2018, 900, 9),
('Book 10', 2019, 1000, 10);

-- Insert some book tags

INSERT INTO book_tag (fk_book_id, tag) VALUES
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
