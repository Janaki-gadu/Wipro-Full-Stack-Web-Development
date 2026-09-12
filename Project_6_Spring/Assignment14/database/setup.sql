CREATE DATABASE IF NOT EXISTS hibernate_training;
USE hibernate_training;

CREATE TABLE IF NOT EXISTS CUSTOMER (
    CustomerID VARCHAR(20) PRIMARY KEY,
    Password VARCHAR(50) NOT NULL,
    Balance DOUBLE NOT NULL
);

CREATE TABLE IF NOT EXISTS COUPON (
    CouponCode VARCHAR(20) PRIMARY KEY,
    OfferPercentage DOUBLE NOT NULL
);

INSERT INTO CUSTOMER (CustomerID, Password, Balance) VALUES
('Cust001', 'Cust001pass', 9000),
('Cust002', 'Cust002pass', 15000),
('Cust003', 'Cust003pass', 500),
('Cust004', 'Cust004pass', 20000),
('Cust005', 'Cust005pass', 850)
ON DUPLICATE KEY UPDATE Password = VALUES(Password);

INSERT INTO COUPON (CouponCode, OfferPercentage) VALUES
('NY2020-00', 0),
('NY2020-05', 5),
('NY2020-10', 10),
('NY2020-20', 20)
ON DUPLICATE KEY UPDATE OfferPercentage = VALUES(OfferPercentage);
