/* Table 'customers' */
CREATE TABLE customers
(
    id        BIGINT      NOT NULL AUTO_INCREMENT,
    `name`    VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    `role`    VARCHAR(10) NOT NULL,
    cpf       VARCHAR(14) NOT NULL,
    email     VARCHAR(50) NOT NULL,
    birthdate DATE        NOT NULL,
    score     INT         NOT NULL,
    paycheck  DOUBLE      NOT NULL,
    teller_id BIGINT      NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT email UNIQUE (email),
    CONSTRAINT cpf UNIQUE (cpf)
);
CREATE INDEX `role` ON customers (`role`);

/* Table 'tellers' */
CREATE TABLE tellers
(
    id         BIGINT       NOT NULL AUTO_INCREMENT,
    `name`     VARCHAR(50)  NOT NULL,
    last_name  VARCHAR(50)  NOT NULL,
    `role`     VARCHAR(10)  NOT NULL,
    cpf        VARCHAR(14)  NOT NULL,
    email      VARCHAR(50)  NOT NULL,
    birthdate  DATE         NOT NULL,
    is_admin   BOOLEAN      NOT NULL DEFAULT FALSE,
    login      VARCHAR(50)  NOT NULL,
    `password` VARCHAR(100) NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT email UNIQUE (email),
    CONSTRAINT cpf UNIQUE (cpf),
    CONSTRAINT login UNIQUE (login)
);
CREATE INDEX `role` ON tellers (`role`);

/* Relation 'tellers_customers' */
ALTER TABLE customers
    ADD CONSTRAINT tellers_customers FOREIGN KEY (teller_id) REFERENCES tellers (id);