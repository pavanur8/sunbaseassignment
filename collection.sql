CREATE COLLECTION document_embeddings (
    id STRING PRIMARY KEY,
    embedding VECTOR(768),  -- Adjust dimension according to your embedding model
    content TEXT
);
