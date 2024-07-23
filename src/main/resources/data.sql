CREATE TABLE products (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    price DECIMAL
);

INSERT INTO products (name, price) VALUES ('producto de prueba', 49.99);