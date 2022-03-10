/* Table 'accounts' */
CREATE TABLE accounts
(
    id          BIGINT NOT NULL,
    customer_id BIGINT NOT NULL,
    balance     DOUBLE NOT NULL,
    PRIMARY KEY (id, customer_id)
);

/* Relation 'customers_accounts' */
ALTER TABLE accounts
    ADD CONSTRAINT customers_accounts
        FOREIGN KEY (customer_id) REFERENCES customers (id);