CREATE TABLE IF NOT EXISTS person_address (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    person_id UUID NOT NULL REFERENCES persons_table(id) ON DELETE CASCADE,
    address_id UUID NOT NULL REFERENCES addresses(id) ON DELETE CASCADE,
    type VARCHAR(16) NOT NULL,
    UNIQUE (person_id, address_id, type)
);
