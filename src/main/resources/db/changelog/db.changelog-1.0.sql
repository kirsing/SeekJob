--liquibase formatted sql

--changeset kirsing:1
CREATE TABLE IF NOT EXISTS users_type
(
    user_type_id SERIAL PRIMARY KEY,
       user_type_name VARCHAR(255) DEFAULT NULL);

--changeset kirsing:2
CREATE TABLE IF NOT EXISTS users
(
    user_id SERIAL PRIMARY KEY,
    email VARCHAR(255) DEFAULT NULL,
    is_active BIT(1) DEFAULT NULL,
    password VARCHAR(255) DEFAULT NULL,
    registration_date TIMESTAMP DEFAULT NULL,
    user_type_id INT REFERENCES users_type(user_type_id));

--changeset kirsing:3
CREATE TABLE IF NOT EXISTS company (
    id SERIAL PRIMARY KEY,
    logo VARCHAR(255) DEFAULT NULL,
    name VARCHAR(255) DEFAULT NULL);


