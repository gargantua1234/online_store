-- \i C:/Users/ablec/Desktop/stronaIn/server/script.sql
DROP TABLE IF EXISTS products;
CREATE TABLE products (
  id SERIAL,
  name VARCHAR(50) NOT NULL,
  series varchar(50) NOT NULL,
  photo VARCHAR(50),
  price NUMERIC(19, 2)  NOT NULL,
  discount DECIMAL,
  CONSTRAINT product_pk PRIMARY KEY (id)
);