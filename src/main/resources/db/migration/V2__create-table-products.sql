CREATE TABLE products(
    id bigint   NOT NULL    auto_increment,
    name        VARCHAR(100) NOT NULL,
    amount      INT   NOT NULL,
    price       DECIMAL(10,2)    NOT NULL,
    category    VARCHAR(50) NOT NULL,
    brand	VARCHAR(50) NOT NULL,
    value_      INT	     NOT NULL,
    unit        VARCHAR(20)  NOT NULL,
    data_Created   DATE    NOT NULL,
    last_Update    DATE,

    PRIMARY KEY(id)
)