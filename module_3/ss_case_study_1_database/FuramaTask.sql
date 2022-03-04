use furama;

-- Task 2:
select * from nhan_vien
where (ho_ten like 'H%' or ho_ten like 'T%' or ho_ten like 'K%') and char_length(ho_ten) <=15;

-- Task 3:
select *, round(datediff(curdate(),ngay_sinh)/365) as tuoi  from khach_hang
where (round(datediff(curdate(),ngay_sinh)/365) between 18 and 50) and (dia_chi like '%Đà Nẵng%' or dia_chi like '%Quảng Trị%');

-- Task 4:
select khach_hang.ma_khach_hang, khach_hang.ho_ten, count(hop_dong.ma_khach_hang) as 'so_lan_dat_phong' from khach_hang
inner join loai_khach on loai_khach.ma_loai_khach = khach_hang.ma_loai_khach
inner join hop_dong on khach_hang.ma_khach_hang = hop_dong.ma_khach_hang
where loai_khach.ma_loai_khach = 1
group by khach_hang.ma_khach_hang
order by so_lan_dat_phong asc;

-- Task 5:
-- select khach_hang.ma_khach_hang, khach_hang.ho_ten, loai_khach.ten_loai_khach, hop_dong.ma_hop_dong, dich_vu.ten_dich_vu, hop_dong.ngay_lam_hop_dong, hop_dong.ngay_ket_thuc, 
-- sum(ifnull(dich_vu.chi_phi_thue,0) + ifnull(hop_dong_chi_tiet.so_luong,0) * ifnull(dich_vu_di_kem.gia,0)) as 'tong_tien' from khach_hang
-- left join loai_khach on loai_khach.ma_loai_khach = khach_hang.ma_loai_khach
-- left join hop_dong on khach_hang.ma_khach_hang = hop_dong.ma_khach_hang
-- left join dich_vu on hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
-- left join hop_dong_chi_tiet on hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
-- left join dich_vu_di_kem on hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
-- group by hop_dong.ma_hop_dong
-- order by ma_khach_hang, ma_hop_dong desc;

create temporary table bang_tam_tinh_tong_tien_dvdk
select hop_dong.ma_khach_hang, hop_dong.ma_hop_dong, hop_dong.ngay_lam_hop_dong, hop_dong.ngay_ket_thuc, hop_dong.ma_dich_vu,
(sum(ifnull(hop_dong_chi_tiet.so_luong,0) * ifnull(dich_vu_di_kem.gia,0)) + ifnull(dich_vu.chi_phi_thue,0)) as tong_tien
from dich_vu 
inner join hop_dong on dich_vu.ma_dich_vu = hop_dong.ma_dich_vu
left join hop_dong_chi_tiet on hop_dong_chi_tiet.ma_hop_dong = hop_dong.ma_hop_dong
left join dich_vu_di_kem on hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
group by hop_dong.ma_hop_dong
order by hop_dong.ma_hop_dong;

select khach_hang.ma_khach_hang, loai_khach.ten_loai_khach, khach_hang.ho_ten, bang_tam_tinh_tong_tien_dvdk.ma_hop_dong, dich_vu.ten_dich_vu, 
bang_tam_tinh_tong_tien_dvdk.ngay_lam_hop_dong, bang_tam_tinh_tong_tien_dvdk.ngay_ket_thuc,
sum(ifnull(bang_tam_tinh_tong_tien_dvdk.tong_tien,0)) as tong_chi_phi
from dich_vu
inner join bang_tam_tinh_tong_tien_dvdk on bang_tam_tinh_tong_tien_dvdk.ma_dich_vu = dich_vu.ma_dich_vu
right join khach_hang on khach_hang.ma_khach_hang = bang_tam_tinh_tong_tien_dvdk.ma_khach_hang
right join loai_khach on loai_khach.ma_loai_khach = khach_hang.ma_loai_khach
group by khach_hang.ma_khach_hang
order by khach_hang.ma_khach_hang;

-- Task 6:
select dich_vu.ma_dich_vu, dich_vu.ten_dich_vu, dich_vu.dien_tich, dich_vu.chi_phi_thue, loai_dich_vu.ten_loai_dich_vu 
from loai_dich_vu
left join dich_vu on loai_dich_vu.ma_loai_dich_vu = dich_vu.ma_loai_dich_vu
left join hop_dong on hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
where dich_vu.ma_dich_vu not in (select hop_dong.ma_dich_vu from hop_dong where (month(ngay_lam_hop_dong) between 1 and 3) and (year(ngay_lam_hop_dong) = 2021))
group by dich_vu.ma_dich_vu
order by dien_tich desc;

-- Task 7:
select dich_vu.ma_dich_vu, dich_vu.ten_dich_vu, dich_vu.dien_tich,dich_vu.so_nguoi_toi_da, dich_vu.chi_phi_thue, loai_dich_vu.ten_loai_dich_vu 
from loai_dich_vu
join dich_vu on loai_dich_vu.ma_loai_dich_vu = dich_vu.ma_loai_dich_vu
join hop_dong on hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
where (dich_vu.ma_dich_vu in (select hop_dong.ma_dich_vu from hop_dong where year(ngay_lam_hop_dong) = 2020)) 
and (dich_vu.ma_dich_vu not in (select hop_dong.ma_dich_vu from hop_dong where year(ngay_lam_hop_dong) = 2021))
group by dich_vu.ma_dich_vu
order by dien_tich desc;

-- Task 8:
-- C1:
select ho_ten from khach_hang
group by ho_ten;
-- C2:
select distinct ho_ten from khach_hang;
-- C3:
select ho_ten from khach_hang union select ho_ten from khach_hang;

-- Task 9:
select month(ngay_lam_hop_dong) as 'thang', count(ma_hop_dong) as 'so_luong_khach_hang' from hop_dong
where year(ngay_lam_hop_dong) = 2021
group by thang
order by thang;

-- Task 10:
select hop_dong.ma_hop_dong, hop_dong.ngay_lam_hop_dong, hop_dong.ngay_ket_thuc, hop_dong.tien_dat_coc, 
sum(ifnull(hop_dong_chi_tiet.so_luong,0)) as so_luong_dich_vu_di_kem
from hop_dong
left join hop_dong_chi_tiet on hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
group by hop_dong.ma_hop_dong
order by hop_dong.ma_hop_dong;

-- Task 11:
select khach_hang.ma_khach_hang, dich_vu_di_kem.ma_dich_vu_di_kem, dich_vu_di_kem.ten_dich_vu_di_kem from loai_khach
inner join khach_hang on khach_hang.ma_loai_khach = loai_khach.ma_loai_khach
inner join hop_dong on hop_dong.ma_khach_hang = khach_hang.ma_khach_hang 
inner join hop_dong_chi_tiet on hop_dong_chi_tiet.ma_hop_dong = hop_dong.ma_hop_dong
inner join dich_vu_di_kem on dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem
where loai_khach.ma_loai_khach = 1 and (dia_chi like '%Vinh%' or dia_chi like '%Quảng Ngãi%');

-- Task 12://
select hop_dong.ma_hop_dong, nhan_vien.ho_ten, khach_hang.ho_ten, khach_hang.so_dien_thoai, dich_vu.ten_dich_vu, 
sum(ifnull(hop_dong_chi_tiet.so_luong,0)) as so_luong_dich_vu_di_kem, hop_dong.tien_dat_coc
from nhan_vien
left join hop_dong on nhan_vien.ma_nhan_vien = hop_dong.ma_nhan_vien
left join khach_hang on hop_dong.ma_khach_hang = khach_hang.ma_khach_hang
left join hop_dong_chi_tiet on hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
left join dich_vu on hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
where (hop_dong.ngay_lam_hop_dong between '2020-10-01 00:00:00' and '2020-12-31 23:59:59') 
and (hop_dong.ngay_lam_hop_dong not between '2021-01-01 00:00:00' and '2021-06-30 23:59:59')
group by hop_dong.ma_hop_dong;

-- Task 13://
select dich_vu_di_kem.ma_dich_vu_di_kem,dich_vu_di_kem.ten_dich_vu_di_kem, sum(hop_dong_chi_tiet.so_luong) as 'so_lan_su_dung'
from hop_dong_chi_tiet
inner join dich_vu_di_kem on hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
group by dich_vu_di_kem.ma_dich_vu_di_kem
having so_lan_su_dung >=(select max(hop_dong_chi_tiet.so_luong) from hop_dong_chi_tiet);

-- Task 14:
select hop_dong.ma_hop_dong, loai_dich_vu.ten_loai_dich_vu, dich_vu_di_kem.ten_dich_vu_di_kem, 
count(dich_vu_di_kem.ma_dich_vu_di_kem) as so_lan_su_dung
from loai_dich_vu
join dich_vu on loai_dich_vu.ma_loai_dich_vu = dich_vu.ma_loai_dich_vu
join hop_dong on dich_vu.ma_dich_vu = hop_dong.ma_dich_vu
join hop_dong_chi_tiet on hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
join dich_vu_di_kem on hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
group by dich_vu_di_kem.ma_dich_vu_di_kem
having so_lan_su_dung = 1
order by hop_dong.ma_hop_dong;

-- Task 15:
select nhan_vien.ma_nhan_vien, nhan_vien.ho_ten, trinh_do.ten_trinh_do, bo_phan.ten_bo_phan, nhan_vien.so_dien_thoai, nhan_vien.dia_chi
from nhan_vien
join trinh_do on nhan_vien.ma_trinh_do = trinh_do.ma_trinh_do
join bo_phan on nhan_vien.ma_bo_phan = bo_phan.ma_bo_phan
join hop_dong on nhan_vien.ma_nhan_vien = hop_dong.ma_nhan_vien
where year(hop_dong.ngay_lam_hop_dong) between 2020 and 2021
group by nhan_vien.ma_nhan_vien
having count(hop_dong.ma_hop_dong) <= 3
order by nhan_vien.ma_nhan_vien;

-- Task 16:
set sql_safe_updates = 0;
delete from nhan_vien 
where nhan_vien.ma_nhan_vien not in (
select hop_dong.ma_nhan_vien
from hop_dong
where year(hop_dong.ngay_lam_hop_dong) between 2019 and 2021
);
set sql_safe_updates =1;

-- Task 17:
-- Tạo bảng tạm
create temporary table khach_hang_du_dieu_kien_len_vip
select khach_hang.ma_khach_hang, khach_hang.ho_ten
from khach_hang
left join loai_khach on loai_khach.ma_loai_khach = khach_hang.ma_loai_khach
left join hop_dong on khach_hang.ma_khach_hang = hop_dong.ma_khach_hang
left join dich_vu on hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
left join hop_dong_chi_tiet on hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
left join dich_vu_di_kem on hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
where year(hop_dong.ngay_lam_hop_dong) = 2021 and dich_vu.chi_phi_thue + hop_dong_chi_tiet.so_luong * dich_vu_di_kem.gia > 10000000
group by hop_dong.ma_hop_dong;

select * from khach_hang_du_dieu_kien_len_vip;

set sql_safe_updates = 0;
update khach_hang
set khach_hang.ma_loai_khach = 1
where khach_hang.ma_khach_hang in (select ma_khach_hang from khach_hang_du_dieu_kien_len_vip);
set sql_safe_updates = 1;

-- Task 18:
set sql_safe_updates = 0;
delete from khach_hang
where khach_hang.ma_khach_hang in (select hop_dong.ma_khach_hang from hop_dong where year(hop_dong.ngay_lam_hop_dong) < 2021);
set sql_safe_updates = 1;

-- Task 19:
create temporary table dich_vu_can_tang_gia
select dich_vu_di_kem.ma_dich_vu_di_kem, dich_vu_di_kem.ten_dich_vu_di_kem, dich_vu_di_kem.gia
from hop_dong_chi_tiet
join dich_vu_di_kem on hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
join hop_dong on hop_dong_chi_tiet.ma_hop_dong = hop_dong.ma_hop_dong
where hop_dong_chi_tiet.so_luong > 10 and year(hop_dong.ngay_lam_hop_dong) = 2020;

set sql_safe_updates = 0;
update dich_vu_di_kem
set dich_vu_di_kem.gia = dich_vu_di_kem.gia * 2
where dich_vu_di_kem.ma_dich_vu_di_kem in (select ma_dich_vu_di_kem from dich_vu_can_tang_gia);
set sql_safe_updates = 1;

-- Task 20:
select nhan_vien.ma_nhan_vien as id, nhan_vien.ho_ten, nhan_vien.email, nhan_vien.so_dien_thoai, nhan_vien.ngay_sinh, nhan_vien.dia_chi, 
'nhan_vien' as role
from nhan_vien
union all
select khach_hang.ma_khach_hang as id, khach_hang.ho_ten, khach_hang.email, khach_hang.so_dien_thoai, khach_hang.ngay_sinh, khach_hang.dia_chi,
'khach_hang' as role
from khach_hang;