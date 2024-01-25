CREATE TABLE users (
                       id SERIAL PRIMARY KEY,
                       username VARCHAR(45) NOT NULL,
                       password VARCHAR(45) NOT NULL,
                       enable INT NOT NULL
);

CREATE TABLE authorities (
                             id SERIAL PRIMARY KEY,
                             username VARCHAR(45) NOT NULL,
                             authority VARCHAR(45) NOT NULL
);
insert into users (username, password, enabled)  VALUES ( 'happy', '12345', '1');
INSERT INTO authorities (username, authority) VALUES ( 'happy', 'write');

DELETE FROM users
WHERE username = 'happy';

ALTER TABLE users RENAME COLUMN enable TO enabled;

SELECT * FROM users LIMIT 1;

CREATE TABLE customer (
                          id SERIAL PRIMARY KEY,
                          email VARCHAR(45) NOT NULL,
                          pwd VARCHAR(45) NOT NULL,
                          role VARCHAR(45) NOT NULL
);

INSERT INTO customer (email, pwd, role) VALUES ( 'user@gmail.com', '54321', 'admin');