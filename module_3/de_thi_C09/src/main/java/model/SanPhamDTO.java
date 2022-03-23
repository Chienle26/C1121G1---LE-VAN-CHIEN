package model;

public class SanPhamDTO {
    private Integer idSanPham;
    private String tenSanPham;
    private Double gia;
    private Integer soLuong;
    private Integer idMauSac;
    private String moTa;
    private Integer idDanhMuc;
    private String mauSac;
    private String danhMuc;

    public SanPhamDTO() {
    }

    public SanPhamDTO(Integer idSanPham, String tenSanPham, Double gia, Integer soLuong, Integer idMauSac, String moTa, Integer idDanhMuc, String mauSac, String danhMuc) {
        this.idSanPham = idSanPham;
        this.tenSanPham = tenSanPham;
        this.gia = gia;
        this.soLuong = soLuong;
        this.idMauSac = idMauSac;
        this.moTa = moTa;
        this.idDanhMuc = idDanhMuc;
        this.mauSac = mauSac;
        this.danhMuc = danhMuc;
    }

    public Integer getIdSanPham() {
        return idSanPham;
    }

    public void setIdSanPham(Integer idSanPham) {
        this.idSanPham = idSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public Double getGia() {
        return gia;
    }

    public void setGia(Double gia) {
        this.gia = gia;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public Integer getIdMauSac() {
        return idMauSac;
    }

    public void setIdMauSac(Integer idMauSac) {
        this.idMauSac = idMauSac;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public Integer getIdDanhMuc() {
        return idDanhMuc;
    }

    public void setIdDanhMuc(Integer idDanhMuc) {
        this.idDanhMuc = idDanhMuc;
    }

    public String getMauSac() {
        return mauSac;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }

    public String getDanhMuc() {
        return danhMuc;
    }

    public void setDanhMuc(String danhMuc) {
        this.danhMuc = danhMuc;
    }
}
