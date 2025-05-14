CREATE TABLE artist (
    id UUID PRIMARY KEY,
    name TEXT,
    active_from DATE,
    active_to DATE
);

CREATE TABLE song (
    id UUID PRIMARY KEY,
    name TEXT,
    artist UUID REFERENCES artist,
    released DATE
);
