CREATE TABLE IF NOT EXISTS contacts_table (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    person_id UUID NOT NULL REFERENCES persons_table(id) ON DELETE CASCADE,
    contact_type  VARCHAR(32) NOT NULL,
    contact_value VARCHAR(128) NOT NULL,
    is_primary BOOLEAN DEFAULT FALSE,
    UNIQUE(person_id, contact_type, contact_value)
);