package reponsitory;

import model.DanhMuc;
import model.MauSac;

import java.util.List;

public interface IMauSacRepository {
    List<MauSac> findAll();
}
