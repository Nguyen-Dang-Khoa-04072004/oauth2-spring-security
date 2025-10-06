INSERT INTO categories(category_name,description) VALUES
('Meat','Some description about this category'),
('Beverage','Some description about this category');

INSERT INTO sub_categories(sub_category_name, description, category_id) VALUES
('Beef','Some description about this sub category',1),
('Pork', 'Some description about this sub category',1),
('Gas Drinking', 'Some description about this sub category',2);

INSERT INTO products(product_id,product_name, price, measure, unit, product_image_url, available_quantity, sub_category_id) VALUES
('e4d631f0-723c-4c49-81c0-b8c167c907c1','Kobe', 1000000,10,'g','http://emxample.koba-image.com',20,1),
('e4d631f0-723c-4c49-81c0-b8c167c907c2','Waygu', 500000,10,'g','http://emxample.waygu-image.com',10,1),
('e4d631f0-723c-4c49-81c0-b8c167c907c3','Sting', 10000,500,'ml','http://emxample.sting-image.com',500,3);