create database xuat_nhap_hang;

use xuat_nhap_hang;

create table phieu_xuat(
so_PX int,
ngay_xuat datetime,
primary key (so_PX)
);

create table vat_tu(
ma_VTU varchar(50),
ten_VTU varchar(50),
primary key (ma_VTU)
);

create table chi_tiet_phieu_xuat(
so_PX int,
ma_VTU varchar(50),
DG_xuat double,
SL_xuat int,
primary key (so_PX,ma_VTU),
foreign key (so_PX) references phieu_xuat(so_PX),
foreign key (ma_VTU) references vat_tu(ma_VTU)
);

create table phieu_nhap(
so_PN int,
ngay_nhap datetime,
primary key(so_PN)
);

create table chi_tiet_phieu_nhap(
ma_VTU varchar(50),
so_PN int,
DG_nhap double,
SL_nhap int,
primary key(ma_VTU,so_PN),
foreign key (ma_VTU) references vat_tu(ma_VTU),
foreign key (so_PN) references phieu_nhap(so_PN)
);

create table nha_cung_cap(
ma_NCC varchar(50),
ten_NCC varchar(50),
dia_chi varchar(50),
primary key (ma_NCC)
);

create table SDT(
sdt varchar(20),
ma_NCC varchar(50),
primary key(ma_NCC, sdt),
foreign key (ma_NCC) references nha_cung_cap(ma_NCC)
);

create table don_hang(
so_DH int,
ngay_DH datetime,
ma_NCC varchar(50),
primary key(so_DH),
foreign key (ma_NCC) references nha_cung_cap(ma_NCC)
);

create table chi_tiet_don_dat_hang(
ma_VTU varchar(50),
so_DH int,
primary key(ma_VTU,so_DH),
foreign key (ma_VTU) references vat_tu(ma_VTU),
foreign key (so_DH) references don_hang(so_DH)
);


