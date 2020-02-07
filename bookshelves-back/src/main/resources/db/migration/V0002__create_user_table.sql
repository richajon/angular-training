CREATE TABLE bookuser (
    id INT GENERATED ALWAYS AS IDENTITY,
    email VARCHAR(100) NOT NULL,
    password_hash VARCHAR(150) NOT NULL
);

CREATE UNIQUE INDEX bookuser_email_idx ON bookuser (email);