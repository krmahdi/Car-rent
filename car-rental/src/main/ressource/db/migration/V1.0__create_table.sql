DROP TABLE IF EXISTS order_table;
DROP TABLE IF EXISTS car_table;
DROP TABLE IF EXISTS user_table;
CREATE TABLE user_table
(
user_id BIGSERIAL PRIMARY KEY NOT NULL,
user_name VARCHAR(100),
user_email VARCHAR(100) NOT NULL UNIQUE,
user_password VARCHAR(100) NOT NULL,
user_adress VARCHAR(255) NOT NULL,
user_blocked BOOL  DEFAULT FALSE,
user_role VARCHAR(50) 
);
CREATE TABLE car_table
(
car_id BIGSERIAL PRIMARY KEY NOT NULL,
car_model VARCHAR(50),
car_release_year VARCHAR(50) ,
car_color VARCHAR(50) ,
car_company VARCHAR(50) 

);
CREATE TABLE order_table(
order_id BIGSERIAL PRIMARY KEY,
user_id BIGSERIAL REFERENCES user_table(user_id),
car_id BIGSERIAL REFERENCES car_table(car_id),
order_date DATE,
return_date DATE,
car_returned BOOL DEFAULT FALSE,
rental_cost NUMERIC(7,2)


);

