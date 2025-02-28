create table COUNTRIES (
	COUNTRY VARCHAR(50) PRIMARY KEY, 
	TERRITORY VARCHAR(50)
);

create table PRODUCTS (
	PRODUCTCODE VARCHAR(50) PRIMARY KEY,  
	PRODUCTLINE VARCHAR(50), 
	MSRP NUMERIC
);

create table CUSTOMERS (
	CUSTOMERNAME VARCHAR(50) PRIMARY KEY, 
	PHONE VARCHAR(13), 
	ADDRESSLINE1 VARCHAR(50), 
	ADDRESSLINE2 VARCHAR(50), 
	CITY VARCHAR(50), 
	STATE VARCHAR(50), 
	POSTALCODE VARCHAR(50), 
	COUNTRY VARCHAR(50) REFERENCES COUNTRIES(COUNTRY), 
	CONTACTLASTNAME VARCHAR(50), 
	CONTACTFIRSTNAME VARCHAR(50)
);

create table ORDERS (
	 ORDERNUMBER INT PRIMARY KEY,
	 ORDERDATE timestamp DEFAULT CURRENT_TIMESTAMP, 
	 STATUS VARCHAR(50), 
	 QTR_ID INT, 
	 MONTH_ID INT, 
	 YEAR_ID INT, 
	 DEALSIZE NUMERIC, 
	 CUSTOMERNAME VARCHAR(50) REFERENCES CUSTOMERS(CUSTOMERNAME)
);

create table ORDERLINES (
	ORDERNUMBER INT REFERENCES ORDERS(ORDERNUMBER), 
	ORDERLINENUMBER INT, 
	QUANTITYORDERED INT, 
	PRICEEACH NUMERIC, 
	PRODUCTCODE VARCHAR(50) REFERENCES PRODUCTS(PRODUCTCODE)
);





