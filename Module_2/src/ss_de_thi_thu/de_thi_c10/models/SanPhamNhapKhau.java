package ss_de_thi_thu.de_thi_c10.models;

public class SanPhamNhapKhau extends SanPham {
    private double giaNhapKhau;
    private String tinhThanhNhap;
    private double thueNhapKhau;

    public SanPhamNhapKhau() {
    }

    public SanPhamNhapKhau(double giaNhapKhau, String tinhThanhNhap, double thueNhapKhau) {
        this.giaNhapKhau = giaNhapKhau;
        this.tinhThanhNhap = tinhThanhNhap;
        this.thueNhapKhau = thueNhapKhau;
    }

    public SanPhamNhapKhau(String maSanPham, String tenSanPham, double giaBan, int soLuong, String nhaSanXuat, double giaNhapKhau, String tinhThanhNhap, double thueNhapKhau) {
        super(maSanPham, tenSanPham, giaBan, soLuong, nhaSanXuat);
        this.giaNhapKhau = giaNhapKhau;
        this.tinhThanhNhap = tinhThanhNhap;
        this.thueNhapKhau = thueNhapKhau;
    }

    public double getGiaNhapKhau() {
        return giaNhapKhau;
    }

    public void setGiaNhapKhau(double giaNhapKhau) {
        this.giaNhapKhau = giaNhapKhau;
    }

    public String getTinhThanhNhap() {
        return tinhThanhNhap;
    }

    public void setTinhThanhNhap(String tinhThanhNhap) {
        this.tinhThanhNhap = tinhThanhNhap;
    }

    public double getThueNhapKhau() {
        return thueNhapKhau;
    }

    public void setThueNhapKhau(double thueNhapKhau) {
        this.thueNhapKhau = thueNhapKhau;
    }

    @Override
    public String toString() {
        return "SanPhamNhapKhau{" +
                "idSanPham=" + idSanPham +
                ", maSanPham='" + maSanPham + '\'' +
                ", tenSanPham='" + tenSanPham + '\'' +
                ", giaBan=" + giaBan +
                ", soLuong=" + soLuong +
                ", nhaSanXuat='" + nhaSanXuat + '\'' +
                ", giaNhapKhau=" + giaNhapKhau +
                ", tinhThanhNhap='" + tinhThanhNhap + '\'' +
                ", thueNhapKhau=" + thueNhapKhau +
                '}';
    }

    @Override
    public String toStringToFileCSV() {
        return super.toStringToFileCSV() + "," + this.giaNhapKhau + "," + this.tinhThanhNhap + "," + this.thueNhapKhau;
    }
}
