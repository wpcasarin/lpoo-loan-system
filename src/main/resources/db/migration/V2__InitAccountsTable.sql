/* Table 'accounts' */
CREATE TABLE accounts
(
    id          BIGINT NOT NULL AUTO_INCREMENT,
    customer_id BIGINT NOT NULL,
    balance     DOUBLE NOT NULL,
    loan_tax    DOUBLE NOT NULL,
    loan_limit  DOUBLE NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT customer_id UNIQUE (customer_id)
);

/* Relation 'customers_accounts' */
ALTER TABLE accounts
    ADD CONSTRAINT customers_accounts
        FOREIGN KEY (customer_id) REFERENCES customers (id);