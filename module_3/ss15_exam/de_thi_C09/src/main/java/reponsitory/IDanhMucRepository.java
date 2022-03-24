package reponsitory;

import model.DanhMuc;

import java.util.List;

public interface IDanhMucRepository {
    List<DanhMuc> findAll();
}
