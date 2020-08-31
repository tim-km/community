DROP TABLE IF EXISTS user__project;
DROP TABLE IF EXISTS user__programming_language;
DROP TABLE IF EXISTS user__spoken_language;
DROP TABLE IF EXISTS project__programming_language;
DROP TABLE IF EXISTS project__spoken_language;
DROP TABLE IF EXISTS spoken_language;
DROP TABLE IF EXISTS project;
DROP TABLE IF EXISTS programming_language;
DROP TABLE IF EXISTS "user";
DROP TABLE IF EXISTS country;


CREATE TABLE country
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(32) UNIQUE NOT NULL
);

CREATE TABLE programming_language
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(34) UNIQUE NOT NULL
);

CREATE TABLE spoken_language
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(32) UNIQUE NOT NULL
);

CREATE TABLE "user"
(
    id           SERIAL PRIMARY KEY,
    username     VARCHAR UNIQUE             NOT NULL,
    first_name   VARCHAR     DEFAULT NULL,
    last_name    VARCHAR     DEFAULT NULL,
    email        VARCHAR UNIQUE             NOT NULL,
    password     VARCHAR                    NOT NULL,
    role         VARCHAR     DEFAULT 'USER' NOT NULL,
    date_created TIMESTAMPTZ DEFAULT now()  NOT NULL,
    country_id   INT         DEFAULT NULL,
    CONSTRAINT fk_country
        FOREIGN KEY (country_id)
            REFERENCES country (id)
);

CREATE TABLE project
(
    id               SERIAL PRIMARY KEY,
    title            VARCHAR                               NOT NULL,
    info             TEXT                                  NOT NULL,
    number_of_people INT         DEFAULT 1                 NOT NULL,
    date_created     TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP NOT NULL,
    owner_id         INT                                   NOT NULL,
    CONSTRAINT fk_owner
        FOREIGN KEY (owner_id)
            REFERENCES "user" (id)
);

CREATE TABLE user__project
(
    user_id    INT NOT NULL,
    project_id INT NOT NULL,
    CONSTRAINT fk_user
        FOREIGN KEY (user_id)
            REFERENCES "user" (id),
    CONSTRAINT fk_project
        FOREIGN KEY (project_id)
            REFERENCES project (id)
);

CREATE TABLE user__programming_language
(
    user_id                 INT NOT NULL,
    programming_language_id INT NOT NULL,
    CONSTRAINT fk_user
        FOREIGN KEY (user_id)
            REFERENCES "user" (id),
    CONSTRAINT fk_programming_language
        FOREIGN KEY (programming_language_id)
            REFERENCES programming_language (id)
);

CREATE TABLE user__spoken_language
(
    user_id            INT NOT NULL,
    spoken_language_id INT NOT NULL,
    CONSTRAINT fk_user
        FOREIGN KEY (user_id)
            REFERENCES "user" (id),
    CONSTRAINT fk_spoken_language
        FOREIGN KEY (spoken_language_id)
            REFERENCES spoken_language (id)
);

CREATE TABLE project__programming_language
(
    project_id              INT NOT NULL,
    programming_language_id INT NOT NULL,
    CONSTRAINT fk_project
        FOREIGN KEY (project_id)
            REFERENCES project (id),
    CONSTRAINT fk_programming_language
        FOREIGN KEY (programming_language_id)
            REFERENCES programming_language (id)
);

CREATE TABLE project__spoken_language
(
    project_id         INT NOT NULL,
    spoken_language_id INT NOT NULL,
    CONSTRAINT fk_project
        FOREIGN KEY (project_id)
            REFERENCES project (id),
    CONSTRAINT fk_spoken_language
        FOREIGN KEY (spoken_language_id)
            REFERENCES spoken_language (id)
);
