show databases;
create database ProjectDB;
use ProjectDB;
   CREATE TABLE PropInfo (
    Pid INT AUTO_INCREMENT PRIMARY KEY,
    PName VARCHAR(255),
    PArea VARCHAR(255),
    Price FLOAT,
    OwnerName VARCHAR(255),
    BuyerName VARCHAR(255)
);


drop table PropInfo;
TRUNCATE TABLE PropInfo;

select * from propinfo;