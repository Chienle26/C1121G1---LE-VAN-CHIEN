package model;

public class DanhMuc {
    private Integer idDanhMuc;
    private String danhMuc;

    public DanhMuc() {
    }

    public DanhMuc(Integer idDanhMuc, String danhMuc) {
        this.idDanhMuc = idDanhMuc;
        this.danhMuc = danhMuc;
    }

    public Integer getIdDanhMuc() {
        return idDanhMuc;
    }

    public void setIdDanhMuc(Integer idDanhMuc) {
        this.idDanhMuc = idDanhMuc;
    }

    public String getDanhMuc() {
        return danhMuc;
    }

    public void setDanhMuc(String danhMuc) {
        this.danhMuc = danhMuc;
    }
}
