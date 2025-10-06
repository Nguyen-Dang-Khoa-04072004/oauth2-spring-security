--liquibase formatted sql

--changeset khoand107:1
CREATE TABLE IF NOT EXISTS products(
    product_id VARCHAR(36) PRIMARY KEY,
    product_name VARCHAR(256) NOT NULL,
    price BIGINT NOT NULL,
    measure INTEGER NOT NULL,
    unit VARCHAR(20) NOT NULL,
    product_image_url TEXT,
    description TEXT,
    available_quantity INTEGER NOT NULL,
    sub_category_id INTEGER NOT NULL
);

CREATE TABLE IF NOT EXISTS sub_categories(
    sub_category_id INTEGER AUTO_INCREMENT PRIMARY KEY ,
    sub_category_name VARCHAR(256) NOT NULL,
    description TEXT,
    category_id INTEGER NOT NULL
);

CREATE TABLE IF NOT EXISTS categories(
    category_id INTEGER AUTO_INCREMENT PRIMARY KEY,
    category_name VARCHAR(256) NOT NULL,
    description TEXT
);

ALTER TABLE products
ADD CONSTRAINT fk_products_sub_categories
FOREIGN KEY (sub_category_id) REFERENCES sub_categories(sub_category_id);

ALTER TABLE sub_categories
ADD CONSTRAINT fk_sub_categories_categories
FOREIGN KEY (category_id) REFERENCES categories(category_id);
