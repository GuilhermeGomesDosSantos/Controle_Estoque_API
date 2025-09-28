CREATE TABLE usuarios(
    id bigint NOT NULL auto_increment,
    login     VARCHAR(100) UNIQUE NOT NULL,
    password    VARCHAR(255) NOT NULL,
    role        VARCHAR(100)    NOT NULL,
    PRIMARY KEY(ID)
)