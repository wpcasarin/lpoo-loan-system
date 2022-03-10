/* Table 'accounts' */
CREATE TABLE accounts
(
    id      BIGINT NOT NULL,
    balance DOUBLE NOT NULL,
    PRIMARY KEY (id)
);

/* Relation 'accounts_customers' */
ALTER TABLE customers
    ADD CONSTRAINT accounts_customers
        FOREIGN KEY (account_id) REFERENCES accounts (id);