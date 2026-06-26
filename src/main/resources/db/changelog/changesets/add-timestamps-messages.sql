--liquibase formatted sql

--changeset developer:add_audit_columns_to_chat_room
--comment: Add createdAt and updatedAt fields for PostgreSQL
ALTER TABLE messages
    ADD COLUMN created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    ADD COLUMN updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP;

--rollback ALTER TABLE chat_room DROP COLUMN created_at, DROP COLUMN updated_at;
