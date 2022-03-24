package model;

public class MauSac {
    private Integer idMauSac;
    private String mauSac;

    public MauSac() {
    }

    public MauSac(Integer idMauSac, String mauSac) {
        this.idMauSac = idMauSac;
        this.mauSac = mauSac;
    }

    public Integer getIdMauSac() {
        return idMauSac;
    }

    public void setIdMauSac(Integer idMauSac) {
        this.idMauSac = idMauSac;
    }

    public String getMauSac() {
        return mauSac;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }
}
