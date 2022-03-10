/* Table 'users' */
CREATE TABLE users
(
    id        BIGINT      NOT NULL AUTO_INCREMENT,
    `name`    VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email     VARCHAR(50) NOT NULL,
    cpf       VARCHAR(11) NOT NULL,
    `role`    VARCHAR(10) NOT NULL,
    birthdate DATE        NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT email UNIQUE (email),
    CONSTRAINT cpf UNIQUE (cpf)
);
CREATE INDEX `role` ON users (`role`);

/* Table 'customers' */
CREATE TABLE customers
(
    users_id BIGINT NOT NULL,
    score    INT    NOT NULL,
    paycheck DOUBLE NOT NULL,
    PRIMARY KEY (users_id)
);

/* Table 'tellers' */
CREATE TABLE tellers
(
    users_id   BIGINT       NOT NULL,
    login      VARCHAR(100) NOT NULL,
    `password` VARCHAR(100) NOT NULL,
    is_admin   BOOLEAN      NOT NULL DEFAULT false,
    PRIMARY KEY (users_id),
    CONSTRAINT login UNIQUE (login)
);

/* Relation 'users_customers' */
ALTER TABLE customers
    ADD CONSTRAINT users_customers
        FOREIGN KEY (users_id) REFERENCES users (id) ON DELETE Cascade ON UPDATE Cascade;

/* Relation 'users_tellers' */
ALTER TABLE tellers
    ADD CONSTRAINT users_tellers
        FOREIGN KEY (users_id) REFERENCES users (id) ON DELETE Cascade ON UPDATE Cascade;
