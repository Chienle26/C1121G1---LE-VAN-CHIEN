package ss_de_thi_thu.de_thi_c10.services;

import ss_de_thi_thu.de_thi_c10.utils.NotFoundProductException;

public interface SanPhamService {
    void themMoi(int luaChonSanPhamTheMoi);
    void xoa() throws NotFoundProductException;
    void hienThi();
    void timKiem();
}
