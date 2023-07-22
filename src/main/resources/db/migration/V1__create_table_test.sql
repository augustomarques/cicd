CREATE TABLE test (
    id BIGINT NOT NULL AUTO_INCREMENT,
    description VARCHAR(150),
    created_at DATETIME,
    PRIMARY KEY (id)
);

CREATE index idx_test_sort ON test (created_at DESC);