CREATE TABLE IF NOT EXISTS identity_documents (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    person_id UUID NOT NULL REFERENCES persons_table(id) ON DELETE CASCADE,
    doc_type  VARCHAR(32) NOT NULL,
    doc_number VARCHAR(64) NOT NULL,
    issued_by VARCHAR(128),
    issue_date DATE,
    UNIQUE(person_id, doc_type)
);