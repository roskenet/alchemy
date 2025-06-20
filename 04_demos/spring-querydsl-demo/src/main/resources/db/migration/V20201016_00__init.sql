CREATE TABLE artist (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name TEXT,
    active_from DATE,
    active_to DATE
);

CREATE TABLE song (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name TEXT,
    artist UUID REFERENCES artist,
    released DATE
);
