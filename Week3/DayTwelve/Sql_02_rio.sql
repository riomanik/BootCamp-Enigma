CREATE SCHEMA OnlineShop2;
-- drop SCHEMA onlineshop2;
USE OnlineShop2;

create table customer (
	id_customer INT PRIMARY KEY,
    nama_customer VARCHAR(50)
    );
    
create table products (
	id_products INT PRIMARY KEY,
    nama_products VARCHAR(100),
	price DECIMAL(10, 2)
    
    );
    
-- create table merchant (
-- 	id_merchant INT PRIMARY KEY,
--     nama_merchant VARCHAR(100),
--     products INT,
--     FOREIGN KEY(products) REFERENCES products(id_products)
-- 	
--     );
create table transaction (
	id_transaction INT PRIMARY KEY,
    id_customer INT,
    id_products INT,
    quantity INT,
    date DATE,
    FOREIGN KEY(id_customer) REFERENCES customer(id_customer),
    FOREIGN KEY(id_products) REFERENCES products(id_products)
	
    );
    
    INSERT INTO customer(id_customer,nama_customer)
    values
    (11001,'junifer'),
    (11002,'Rio'),
    (11003,'naldi'),
    (11004,'manik'),
    (11005,'uye');
    
    INSERT INTO products(id_products,nama_products,price)
    VALUES
    (21001,'Autocad',1000000),
    (21002,'Civil 3D',2000000),
    (21003,'Fusion 360',3000000),
    (21004,'3DS Max',4000000),
    (21005,'Maya',5000000),
    (21006,'Revit',6000000);
    
--     INSERT INTO merchant(id_merchant,nama_merchant,product)
--     VALUES
--     (31001,'AutoDesk',21001),
--     (31002,'AutoDesk',21002),
--     (31003,'AutoDesk',21003),
--     (31004,'AutoDesk',21004),
--     (31005,'AutoDesk',21005),
--     (31006,'AutoDesk',21006);
    
    INSERT INTO transaction(id_transaction,id_customer,id_products,quantity,date)
    VALUES
    (41001,11001,21001,2,'2019-10-10'),
    (41002,11002,21003,1,'2019-10-10'),
    (41003,11001,21004,3,'2019-10-10'),
    (41004,11003,21005,1,'2019-10-11'),
    (41005,11001,21002,2,'2019-10-12'),
    (41006,11001,21003,3,'2019-10-15');
    
    SELECT * FROM customer;
    SELECT * FROM products;
    SELECT * FROM transaction;
    
    
 --    1.YANG DIBELI HARI INI
    
    select l.nama_customer,p.nama_products,p.price,tr.date from transaction tr
	inner join products p on p.id_products = tr.id_products
    inner join customer l on l.id_customer = tr.id_customer
	where date = '2019-10-10';
    
    -- 2.TOTAL BELANJA HARI INI
    
	select l.nama_customer,sum(p.price),tr.date from transaction tr
	inner join products p on p.id_products = tr.id_products
    inner join customer l on l.id_customer = tr.id_customer
	where date = '2019-10-10'
    group by nama_customer;
    
   --  3. BARANG TERMAHAL YANG DIBELI
	select l.nama_customer,p.nama_products,p.price,tr.date from transaction tr
	INNER join products p on p.id_products = tr.id_products
    inner join customer l on l.id_customer = tr.id_customer
    GROUP BY p.price DESC
    LIMIT 1;
    
    
  --   4.BARANG TERMURAH YANG DIBELI
    select l.nama_customer,p.nama_products,min(p.price),tr.date from transaction tr
	inner join products p on p.id_products = tr.id_products
    inner join customer l on l.id_customer = tr.id_customer;
--     group by nama_products;
    
--     5.RATA RATA TOTAL BELANJA DALAM SEBULAN
    select l.nama_customer,p.nama_products, avg(p.price*tr.quantity) ,tr.date from transaction tr
	inner join products p on p.id_products = tr.id_products
    inner join customer l on l.id_customer = tr.id_customer
    where date(tr.date) BETWEEN '2019-10-10' AND '2019-11-11';
    

    -- 6.BARANG YANG PALING LAKU (TOP 3)    
    select nama_products,sum(tr.quantity)  from products p
	inner join transaction tr on p.id_products = tr.id_products
	GROUP BY nama_products
    ORDER BY sum(tr.quantity) DESC 
    LIMIT 3;    
 
    -- 7.TOP 3 pembeli spender     
    select l.nama_customer,p.nama_products,sum(p.price*tr.quantity) as Total_Pengeluaran,tr.date from transaction tr
	inner join products p on p.id_products = tr.id_products
    inner join customer l on l.id_customer = tr.id_customer
	GROUP BY nama_customer ORDER BY Total_Pengeluaran DESC
    LIMIT 3;

    
    
    
    