CREATE TABLE "user"
(
    id           SERIAL PRIMARY KEY,
    username     VARCHAR UNIQUE                        NOT NULL,
    first_name   VARCHAR     DEFAULT NULL,
    last_name    VARCHAR     DEFAULT NULL,
    email        VARCHAR UNIQUE                        NOT NULL,
    password     VARCHAR                               NOT NULL,
    role         VARCHAR     DEFAULT 'USER',
    date_created TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP NOT NULL,
    country_id   INT         DEFAULT NULL,
    CONSTRAINT fk_country
        FOREIGN KEY (country_id)
            REFERENCES country (id)
);

CREATE TABLE project
(
    id               SERIAL PRIMARY KEY,
    title            VARCHAR NOT NULL,
    info             TEXT    NOT NULL,
    number_of_people INT     NOT NULL DEFAULT 1,
    date_created     TIMESTAMPTZ      DEFAULT CURRENT_TIMESTAMP NOT NULL,
    owner_id         INT,
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
