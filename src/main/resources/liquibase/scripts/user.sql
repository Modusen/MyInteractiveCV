-- liquibase formatted sql

-- changeset AstrashenyaDmitriy:1
CREATE TABLE IF NOT EXISTS image
(
    id         INTEGER AUTO_INCREMENT PRIMARY KEY,
    file_path  VARCHAR(255),
    file_size  BIGINT,
    media_type VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS users
(
    id               INTEGER AUTO_INCREMENT PRIMARY KEY,
    email            VARCHAR(255) NOT NULL,
    password         VARCHAR(255) NOT NULL,
    confirm_password VARCHAR(255) NOT NULL,
    first_name       VARCHAR(255) NOT NULL,
    last_name        VARCHAR(255) NOT NULL,
    specialization   VARCHAR(255) NOT NULL,
    city             VARCHAR(255) NOT NULL,
    birth_date       DATE         NOT NULL,
    about_me         VARCHAR(255) NOT NULL,
    image            INTEGER,
    role             VARCHAR(255) NOT NULL,
    FOREIGN KEY (image) REFERENCES image (id)
);

CREATE TABLE IF NOT EXISTS education
(
    id              INTEGER AUTO_INCREMENT PRIMARY KEY,
    university_name VARCHAR(255) NOT NULL,
    speciality      VARCHAR(255) NOT NULL,
    years_of_study  VARCHAR(255) NOT NULL,
    user_id         INTEGER      NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users (id)
);

CREATE TABLE IF NOT EXISTS socials
(
    id             INTEGER AUTO_INCREMENT PRIMARY KEY,
    link           VARCHAR(255) NOT NULL,
    specialization VARCHAR(255) NOT NULL,
    user_id        INTEGER      NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users (id)
);
