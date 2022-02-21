package ss_de_thi_that_c11.de_thi_c11.services;

import ss_de_thi_thu.de_thi_c10.utils.NotFoundProductException;

public interface BenhAnService {
    void themMoi(int luaChonBenhAnTheMoi);
    void xoa() throws NotFoundProductException;
    void hienThi();
}
