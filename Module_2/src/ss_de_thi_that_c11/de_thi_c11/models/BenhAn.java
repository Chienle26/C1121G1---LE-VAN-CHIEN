package ss_de_thi_that_c11.de_thi_c11.models;

public abstract class BenhAn {
    static int soBenhAn = 1;
    int soThuTuBenhAn;
    String maBenhAn;
    String tenBenhAn;
    String tenBenhNhan;
    String ngayNhapVien;
    String ngayRaVien;
    String lyDoNhapVien;

    public BenhAn() {
        soThuTuBenhAn = soBenhAn++;
    }

    public BenhAn(String maBenhAn, String tenBenhAn, String tenBenhNhan, String ngayNhapVien, String ngayRaVien, String lyDoNhapVien) {
        this.soThuTuBenhAn = soBenhAn++;
        this.maBenhAn = maBenhAn;
        this.tenBenhAn = tenBenhAn;
        this.tenBenhNhan = tenBenhNhan;
        this.ngayNhapVien = ngayNhapVien;
        this.ngayRaVien = ngayRaVien;
        this.lyDoNhapVien = lyDoNhapVien;
    }

    public static int getSoBenhAn() {
        return soBenhAn;
    }

    public static void setSoBenhAn(int soBenhAn) {
        BenhAn.soBenhAn = soBenhAn;
    }

    public int getSoThuTuBenhAn() {
        return soThuTuBenhAn;
    }

    public void setSoThuTuBenhAn(int soThuTuBenhAn) {
        this.soThuTuBenhAn = soThuTuBenhAn;
    }

    public String getMaBenhAn() {
        return maBenhAn;
    }

    public void setMaBenhAn(String maBenhAn) {
        this.maBenhAn = maBenhAn;
    }

    public String getTenBenhAn() {
        return tenBenhAn;
    }

    public void setTenBenhAn(String tenBenhAn) {
        this.tenBenhAn = tenBenhAn;
    }

    public String getTenBenhNhan() {
        return tenBenhNhan;
    }

    public void setTenBenhNhan(String tenBenhNhan) {
        this.tenBenhNhan = tenBenhNhan;
    }

    public String getNgayNhapVien() {
        return ngayNhapVien;
    }

    public void setNgayNhapVien(String ngayNhapVien) {
        this.ngayNhapVien = ngayNhapVien;
    }

    public String getNgayRaVien() {
        return ngayRaVien;
    }

    public void setNgayRaVien(String ngayRaVien) {
        this.ngayRaVien = ngayRaVien;
    }

    public String getLyDoNhapVien() {
        return lyDoNhapVien;
    }

    public void setLyDoNhapVien(String lyDoNhapVien) {
        this.lyDoNhapVien = lyDoNhapVien;
    }

    @Override
    public String toString() {
        return "BenhAn{" +
                "soThuTuBenhAn=" + soThuTuBenhAn +
                ", maBenhAn='" + maBenhAn + '\'' +
                ", tenBenhAn='" + tenBenhAn + '\'' +
                ", tenBenhNhan='" + tenBenhNhan + '\'' +
                ", ngayNhapVien='" + ngayNhapVien + '\'' +
                ", ngayRaVien='" + ngayRaVien + '\'' +
                ", lyDoNhapVien='" + lyDoNhapVien + '\'' +
                '}';
    }

    public String toStringToFileCSV() {
        return this.soThuTuBenhAn + "," + this.maBenhAn + "," + this.tenBenhAn + "," + this.tenBenhNhan + "," + this.ngayNhapVien + "," + this.ngayRaVien + "," + this.lyDoNhapVien;
    }
}
