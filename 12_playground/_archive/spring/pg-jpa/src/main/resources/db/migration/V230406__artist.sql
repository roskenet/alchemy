CREATE TABLE artist (
    id SERIAL PRIMARY KEY,
    name TEXT -- NOT NULL
);

CREATE INDEX ON artist(name);

CREATE TABLE album (
    id SERIAL PRIMARY KEY,
    artist_id INTEGER REFERENCES artist(id),
    name TEXT -- NOT NULL
);