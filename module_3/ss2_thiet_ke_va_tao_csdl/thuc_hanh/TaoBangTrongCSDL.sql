create database quan_ly_diem_thi;

use quan_ly_diem_thi;

create table hoc_sinh(
ma_hs varchar(20) primary key,
ten_hs varchar(50),
ngay_sinh datetime,
lop varchar(20),
GT varchar(20)
);

create table mon_hoc(
ma_MH varchar(20) primary key,
ten_MH varchar(50)
);

create table bang_diem(
Ma_HS VARCHAR(20),
Ma_MH VARCHAR(20),
diem_thi int,
ngay_KT datetime,
primary key (Ma_HS,Ma_MH),
foreign key (Ma_HS) references hoc_sinh(ma_hs),
foreign key (ma_mh) references mon_hoc(ma_mh)
);

CREATE TABLE Giao_Vien(
    Ma_GV VARCHAR(20) PRIMARY KEY,
    Ten_GV VARCHAR(20),
    SDT VARCHAR(10)
);

alter table mon_hoc add Ma_GV varchar(20);
alter table mon_hoc add constraint FK_Ma_GV foreign key (Ma_GV) references giao_vien(ma_gv);

select * from bang_diem;

