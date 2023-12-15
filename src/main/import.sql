DROP DATABASE IF EXISTS db_to_many;
CREATE DATABASE IF NOT EXISTS db_to_many;
USE db_to_many;

CREATE TABLE IF NOT EXISTS tb_category
(
	id   BIGINT UNSIGNED AUTO_INCREMENT,
	name VARCHAR(100)    NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS tb_product
(
	id    BIGINT UNSIGNED AUTO_INCREMENT,
	name  VARCHAR(100)    NOT NULL,
	price DECIMAL(10, 2)  NOT NULL,

	PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS tb_product_category
(
	product_id  BIGINT UNSIGNED NOT NULL,
	category_id BIGINT UNSIGNED NOT NULL,

	PRIMARY KEY (product_id, category_id),
	FOREIGN KEY (product_id) REFERENCES tb_product (id),
	FOREIGN KEY (category_id) REFERENCES tb_category (id)
);

INSERT INTO tb_category (name) VALUES ('Livros');
INSERT INTO tb_category (name) VALUES ('Eletrônicos');
INSERT INTO tb_category (name) VALUES ('Computadores');

INSERT INTO tb_product (name, price) VALUES ('The Lord of the Rings', 90.5);
INSERT INTO tb_product (name, price) VALUES ('Smart TV', 2190.0);
INSERT INTO tb_product (name, price) VALUES ('Macbook Pro', 1250.0);
INSERT INTO tb_product (name, price) VALUES ('PC Gamer', 1200.0);

INSERT INTO tb_product_category (product_id, category_id) VALUES (1, 1);
INSERT INTO tb_product_category (product_id, category_id) VALUES (2, 2);
INSERT INTO tb_product_category (product_id, category_id) VALUES (2, 3);
INSERT INTO tb_product_category (product_id, category_id) VALUES (3, 3);
INSERT INTO tb_product_category (product_id, category_id) VALUES (4, 3);

SELECT * FROM tb_category;
SELECT * FROM tb_product;
SELECT * FROM tb_product_category;