CREATE TABLE subscriber (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    subscribed_at TIMESTAMP NOT NULL,
    is_active BOOLEAN NOT NULL
);