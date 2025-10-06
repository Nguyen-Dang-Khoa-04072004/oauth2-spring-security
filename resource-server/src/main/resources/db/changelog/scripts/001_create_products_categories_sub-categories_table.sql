--liquibase formatted sql

--changeset khoand107:1
CREATE TABLE IF NOT EXISTS products(
    product_id VARCHAR(32) PRIMARY KEY,
    product_name VARCHAR(256) NOT NULL,
    price
)