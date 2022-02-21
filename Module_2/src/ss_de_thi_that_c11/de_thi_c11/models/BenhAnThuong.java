package ss_de_thi_that_c11.de_thi_c11.models;

public class BenhAnThuong extends BenhAn {
    private double phiNamVien;

    public BenhAnThuong() {
    }

    public BenhAnThuong(double phiNamVien) {
        this.phiNamVien = phiNamVien;
    }

    public BenhAnThuong(String maBenhAn, String tenBenhAn, String tenBenhNhan, String ngayNhapVien, String ngayRaVien, String lyDoNhapVien, double phiNamVien) {
        super(maBenhAn, tenBenhAn, tenBenhNhan, ngayNhapVien, ngayRaVien, lyDoNhapVien);
        this.phiNamVien = phiNamVien;
    }

    public double getPhiNamVien() {
        return phiNamVien;
    }

    public void setPhiNamVien(double phiNamVien) {
        this.phiNamVien = phiNamVien;
    }

    @Override
    public String toString() {
        return "BenhAnThuong{" +
                "soThuTuBenhAn=" + soThuTuBenhAn +
                ", maBenhAn='" + maBenhAn + '\'' +
                ", tenBenhAn='" + tenBenhAn + '\'' +
                ", tenBenhNhan='" + tenBenhNhan + '\'' +
                ", ngayNhapVien='" + ngayNhapVien + '\'' +
                ", ngayRaVien='" + ngayRaVien + '\'' +
                ", lyDoNhapVien='" + lyDoNhapVien + '\'' +
                ", phiNamVien=" + phiNamVien +
                '}';
    }

    @Override
    public String toStringToFileCSV() {
        return super.toStringToFileCSV() + "," + this.phiNamVien;
    }
}
