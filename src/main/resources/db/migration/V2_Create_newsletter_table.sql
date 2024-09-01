CREATE TABLE newsletter (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    content TEXT NOT NULL,
    sent_at TIMESTAMP,
    subscriber_id BIGINT,
    CONSTRAINT fk_subscriber
      FOREIGN KEY(subscriber_id)
      REFERENCES subscriber(id)
);