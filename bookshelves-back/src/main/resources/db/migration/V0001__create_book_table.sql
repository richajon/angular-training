CREATE TABLE book (
    id INT GENERATED ALWAYS AS IDENTITY,
    name VARCHAR(100) NOT NULL,
    status VARCHAR(100) NOT NULL
);