CREATE TABLE User (
    id INTEGER NOT NULL AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(200) NOT NULL,
    is_active BOOLEAN,
    created_date DATETIME NOT NULL,
    PRIMARY KEY (username),
    UNIQUE KEY (id)
);