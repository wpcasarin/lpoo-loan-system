/* Table 'users' */
CREATE TABLE users
(
    id        INT         NOT NULL AUTO_INCREMENT,
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
