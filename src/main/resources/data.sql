CREATE TABLE products (
 id INT NOT NULL AUTO_INCREMENT,
 name VARCHAR(255) NOT NULL,
 description TEXT NOT NULL,
 price DECIMAL(10,2) NOT NULL,
 quantity INT NOT NULL,
 PRIMARY KEY (id)
);

INSERT INTO products (id, name, description, price, quantity) VALUES (1, 'iPhone 13 Pro',
'6.1-inch Super Retina XDR display, A15 Bionic chip', 999.00, 100);
INSERT INTO products (id, name, description, price, quantity) VALUES (2, 'Samsung
Galaxy S21 Ultra', '6.8-inch Dynamic AMOLED 2X display, Exynos 2100 chip', 1199.00,
50);
INSERT INTO products (id, name, description, price, quantity) VALUES (3, 'Google Pixel 6
Pro', '6.7-inch Fluid AMOLED display, Tensor chip', 1099.00, 25);
INSERT INTO products (id, name, description, price, quantity) VALUES (4, 'MacBook Pro',
'13-inch Retina display, Apple M1 chip', 1299.00, 20);
INSERT INTO products (id, name, description, price, quantity) VALUES (5, 'Microsoft
Surface Laptop 4', '13.5-inch PixelSense display, Intel Core i5 chip', 999.00, 15);
INSERT INTO products (id, name, description, price, quantity) VALUES (6, 'Dell XPS 13',
'13.4-inch InfinityEdge display, Intel Core i7 chip', 1199.00, 10);
INSERT INTO products (id, name, description, price, quantity) VALUES (7, 'Sony
PlayStation 5', 'AMD Zen 2 CPU, AMD RDNA 2 GPU', 499.00, 5);
INSERT INTO products (id, name, description, price, quantity) VALUES (8, 'Microsoft Xbox
Series X', 'AMD Zen 2 CPU, AMD RDNA 2 GPU', 499.00, 2);
INSERT INTO products (id, name, description, price, quantity) VALUES (9, 'Bose
QuietComfort 35 II', 'Noise-cancelling headphones with Alexa voice control', 299.00, 1);
INSERT INTO products (id, name, description, price, quantity) VALUES (10, 'Apple AirPods
Pro', 'Active noise cancellation, spatial audio, transparency mode', 249.00, 0);