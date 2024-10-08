--liquibase formatted sql

--changeset kirsing:1
CREATE TABLE IF NOT EXISTS applicant_profile
(
    user_account_id SERIAL PRIMARY KEY REFERENCES users(user_id),
       city VARCHAR(255) DEFAULT NULL,
       country VARCHAR(255) DEFAULT NULL,
       employment_type VARCHAR(255) DEFAULT NULL,
       first_name VARCHAR(255) DEFAULT NULL,
       last_name VARCHAR(255) DEFAULT NULL,
       profile_photo VARCHAR(64) DEFAULT NULL,
       resume VARCHAR(255) DEFAULT NULL,
       state VARCHAR(255) DEFAULT NULL,
       work_authorization VARCHAR(255) DEFAULT NULL
);

--changeset kirsing:2
CREATE TABLE IF NOT EXISTS recruiter_profile
(
    user_account_id SERIAL PRIMARY KEY REFERENCES users(user_id),
    city VARCHAR(255) DEFAULT NULL,
    company VARCHAR(255) DEFAULT NULL,
    country VARCHAR(255) DEFAULT NULL,
    employment_type VARCHAR(255) DEFAULT NULL,
    first_name VARCHAR(255) DEFAULT NULL,
    last_name VARCHAR(255) DEFAULT NULL,
    profile_photo VARCHAR(64) DEFAULT NULL,
    state VARCHAR(255) DEFAULT NULL
);

--changeset kirsing:3
CREATE TABLE IF NOT EXISTS skills
(
    id               SERIAL PRIMARY KEY,
    experience_level VARCHAR(255) DEFAULT NULL,
    name             VARCHAR(255) DEFAULT NULL,
    years_of_experience  VARCHAR(255) DEFAULT NULL,
    applicant_profile INT REFERENCES applicant_profile(user_account_id)
)


