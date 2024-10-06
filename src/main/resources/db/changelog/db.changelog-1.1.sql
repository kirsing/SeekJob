--liquibase formatted sql

--changeset kirsing:1
Alter TABLE users_type
    RENAME COLUMN id TO user_type_id;




