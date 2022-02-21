package ss_de_thi_that_c11.de_thi_c11.models;

public class BenhAnVip extends BenhAn {
    private String loaiVip;
    private String thoiHanVip;

    public BenhAnVip() {
    }


    public BenhAnVip(String loaiVip, String thoiHanVip) {
        this.loaiVip = loaiVip;
        this.thoiHanVip = thoiHanVip;
    }

    public BenhAnVip(String maBenhAn, String tenBenhAn, String tenBenhNhan, String ngayNhapVien, String ngayRaVien, String lyDoNhapVien, String loaiVip, String thoiHanVip) {
        super(maBenhAn, tenBenhAn, tenBenhNhan, ngayNhapVien, ngayRaVien, lyDoNhapVien);
        this.loaiVip = loaiVip;
        this.thoiHanVip = thoiHanVip;
    }

    public String getLoaiVip() {
        return loaiVip;
    }

    public void setLoaiVip(String loaiVip) {
        this.loaiVip = loaiVip;
    }

    public String getThoiHanVip() {
        return thoiHanVip;
    }

    public void setThoiHanVip(String thoiHanVip) {
        this.thoiHanVip = thoiHanVip;
    }

    @Override
    public String toString() {
        return "BenhAnVip{" +
                "soThuTuBenhAn=" + soThuTuBenhAn +
                ", maBenhAn='" + maBenhAn + '\'' +
                ", tenBenhAn='" + tenBenhAn + '\'' +
                ", tenBenhNhan='" + tenBenhNhan + '\'' +
                ", ngayNhapVien='" + ngayNhapVien + '\'' +
                ", ngayRaVien='" + ngayRaVien + '\'' +
                ", lyDoNhapVien='" + lyDoNhapVien + '\'' +
                ", loaiVip='" + loaiVip + '\'' +
                ", thoiHanVip='" + thoiHanVip + '\'' +
                '}';
    }

    @Override
    public String toStringToFileCSV() {
        return super.toStringToFileCSV() + ","   + this.loaiVip + "," + this.thoiHanVip;
    }
}
