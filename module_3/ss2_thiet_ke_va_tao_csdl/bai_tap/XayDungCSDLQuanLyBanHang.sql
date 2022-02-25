create database quan_ly_ban_hang;
use quan_ly_ban_hang;

create table Customer (
cID varchar(20) primary key,
cName varchar(50),
cAge int
);

create table `Order`(
cID varchar(20),
oID varchar(20) primary key,
oDate datetime,
oTotalPrice double,
foreign key(cID) references Customer(cID)
);

create table Product(
pID varchar(20) primary key,
pName varchar(50),
pPrice double
);

create table `Order_Detail`(
oID varchar(20),
pID varchar(20),
odQTY int,
primary key(oID,pID),
foreign key (oID) references `Order`(oID),
foreign key (pID) references Product(pID)
);

-- drop database quan_ly_ban_hang;


