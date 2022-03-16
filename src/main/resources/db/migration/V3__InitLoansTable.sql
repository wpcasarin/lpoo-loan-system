/* Table 'loans' */
/* Table 'loans' */
CREATE TABLE loans
(
    id          BIGINT NOT NULL AUTO_INCREMENT,
    borrowed    DOUBLE NOT NULL,
    to_receive  DOUBLE NOT NULL,
    borrowed_at DATE   NOT NULL,
    expires_at  DATE   NOT NULL,
    account_id  BIGINT NOT NULL,
    PRIMARY KEY (id)
);

/* Relation 'accounts_loans' */
ALTER TABLE loans
    ADD CONSTRAINT accounts_loans FOREIGN KEY (account_id) REFERENCES accounts (id);