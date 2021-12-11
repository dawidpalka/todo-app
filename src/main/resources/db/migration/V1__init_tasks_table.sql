DROP TABLE IF EXISTS tasks;
CREATE TABLE tasks(
    id INT PRIMARY KEY auto_increment,
    description VARCHAR(100) NOT NULL,
    done bit
)