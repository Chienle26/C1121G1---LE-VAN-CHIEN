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
select khach_hang.ma_khach_hang, khach_hang.ho_ten, loai_khach.ten_loai_khach, hop_dong.ma_hop_dong, dich_vu.ten_dich_vu, hop_dong.ngay_lam_hop_dong, hop_dong.ngay_ket_thuc, 
-- sum (dich_vu.chi_phi_thue + hop_dong_chi_tiet.so_luong * dich_vu_di_kem.gia) as tong_tien from khach_hang
sum(ifnull(dich_vu.chi_phi_thue,0) + ifnull(hop_dong_chi_tiet.so_luong,0) * ifnull(dich_vu_di_kem.gia,0)) as 'tong_tien' from khach_hang
left join loai_khach on loai_khach.ma_loai_khach = khach_hang.ma_loai_khach
left join hop_dong on khach_hang.ma_khach_hang = hop_dong.ma_khach_hang
left join dich_vu on hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
left join hop_dong_chi_tiet on hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
left join dich_vu_di_kem on hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
group by hop_dong.ma_hop_dong
order by ma_khach_hang, ma_hop_dong desc;

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
left join dich_vu on loai_dich_vu.ma_loai_dich_vu = dich_vu.ma_loai_dich_vu
left join hop_dong on hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
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



