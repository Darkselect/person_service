CREATE TABLE IF NOT EXISTS addresses(
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    region VARCHAR(64) NOT NULL,
    city VARCHAR(64) NOT NULL,
    street VARCHAR(128) NOT NULL,
    building VARCHAR(32),
    apartment VARCHAR(32)
);