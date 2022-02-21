package ss_de_thi_thu.de_thi_c10.services;

import ss_de_thi_thu.de_thi_c10.models.SanPham;
import ss_de_thi_thu.de_thi_c10.models.SanPhamNhapKhau;
import ss_de_thi_thu.de_thi_c10.models.SanPhamXuatKhau;
import ss_de_thi_thu.de_thi_c10.utils.NotFoundProductException;
import ss_de_thi_thu.de_thi_c10.utils.ReadAndWriteFileToCSVC10;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SanPhamServiceImpl implements SanPhamService {
    static final String SAN_PHAM = "src/ss_de_thi_thu/de_thi_c10/data/SanPham.CSV";
    Scanner scanner = new Scanner(System.in);

    @Override
    public void themMoi(int luaChonSanPhamThemMoi) {
        List<SanPham> sanPhamNhapKhauList = new ArrayList<>();
        List<SanPham> sanPhamXuatKhauList = new ArrayList<>();
        List<String> stringNhapKhauList;
        List<String> stringXuatKhauList;

        System.out.print("Nhập mã sản phẩm: ");
        String maSanPham = scanner.nextLine();
        System.out.print("Nhập tên sản phẩm: ");
        String tenSanPham = scanner.nextLine();
        System.out.print("Nhập giá bán sản phẩm: ");
        double giaBan = Double.parseDouble(scanner.nextLine());
        System.out.print("Nhập số lượng sản phẩm: ");
        int soLuong = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập nhà sản xuất sản phẩm: ");
        String nhaSanXuat = scanner.nextLine();
        switch (luaChonSanPhamThemMoi) {
            case 1:
                System.out.print("Nhập giá nhập khẩu sản phẩm: ");
                double giaNhapKhau = Double.parseDouble(scanner.nextLine());
                System.out.print("Nhập tỉnh thành nhập khẩu sản phẩm: ");
                String tinhThanhNhap = scanner.nextLine();
                System.out.print("Nhập thuế nhập khẩu sản phẩm: ");
                double thueNhapKhau = Double.parseDouble(scanner.nextLine());
                sanPhamNhapKhauList = new ArrayList<>();
                SanPhamNhapKhau sanPhamNhapKhau = new SanPhamNhapKhau(maSanPham, tenSanPham, giaBan, soLuong, nhaSanXuat, giaNhapKhau, tinhThanhNhap, thueNhapKhau);
                sanPhamNhapKhauList.add(sanPhamNhapKhau);
                stringNhapKhauList = ReadAndWriteFileToCSVC10.chuyenSanPhamListSangStringList(sanPhamNhapKhauList);
                ReadAndWriteFileToCSVC10.writeFileToSanPham(SAN_PHAM, stringNhapKhauList, true);
                System.out.println("Thêm mới thành công sản phẩm nhập khẩu!");
                break;
            case 2:
                System.out.print("Nhập giá xuất khẩu sản phẩm: ");
                double giaXuatKhau = Double.parseDouble(scanner.nextLine());
                System.out.print("Nhập quốc gia nhập khẩu sản phẩm: ");
                String quocGiaNhapSanPham = scanner.nextLine();
                sanPhamXuatKhauList = new ArrayList<>();
                SanPhamXuatKhau sanPhamXuatKhau = new SanPhamXuatKhau(maSanPham, tenSanPham, giaBan, soLuong, nhaSanXuat, giaXuatKhau, quocGiaNhapSanPham);
                sanPhamXuatKhauList.add(sanPhamXuatKhau);
                stringXuatKhauList = ReadAndWriteFileToCSVC10.chuyenSanPhamListSangStringList(sanPhamXuatKhauList);
                ReadAndWriteFileToCSVC10.writeFileToSanPham(SAN_PHAM, stringXuatKhauList, true);
                System.out.println("Thêm mới thành công sản phẩm xuất khẩu!");
                break;
        }
    }

    @Override
    public void xoa() throws NotFoundProductException {
        List<String> stringSanPhamList = ReadAndWriteFileToCSVC10.readFileSanPham(SAN_PHAM);
        List<SanPham> sanPhamList = ReadAndWriteFileToCSVC10.chuyenStringListSangSanPhamList(stringSanPhamList);
        System.out.print("Nhập mã sản phẩm cần xóa: ");
        String maSanPhamCanXoa = scanner.nextLine();
        Boolean kiemtra = true;
        for (SanPham sanPham : sanPhamList) {
            if (sanPham.getMaSanPham().equals(maSanPhamCanXoa)) {
                try {
                    System.out.println("Bạn có chắc xóa sản phẩm này không?");
                    System.out.println("1.Yes");
                    System.out.println("2.No");
                    System.out.print("Bạn chọn: ");
                    kiemtra = false;
                    int luaChonXoa = Integer.parseInt(scanner.nextLine());
                    switch (luaChonXoa) {
                        case 1:
                            sanPhamList.remove(sanPham);
                            stringSanPhamList = ReadAndWriteFileToCSVC10.chuyenSanPhamListSangStringList(sanPhamList);
                            ReadAndWriteFileToCSVC10.writeFileToSanPham(SAN_PHAM, stringSanPhamList, false);
                            hienThi();
                            break;
                        case 2:
                            System.out.println("Đã hủy xóa!");
                            break;
                        default:
                            throw new NotFoundProductException("Bạn nhập không đúng!");
                    }
                } catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }
        }
        if (kiemtra){
            throw new NotFoundProductException("Không tìm thấy sản phẩm cần xóa!!!");
        }
    }

    @Override
    public void hienThi() {
        List<String> stringList = ReadAndWriteFileToCSVC10.readFileSanPham(SAN_PHAM);
        List<SanPham> sanPhamList = ReadAndWriteFileToCSVC10.chuyenStringListSangSanPhamList(stringList);
        System.out.println("Danh Sách Sản Phẩm: ");
        for (SanPham sanPham : sanPhamList) {
            System.out.println(sanPham);
        }
    }

    @Override
    public void timKiem() {
        hienThi();
        List<String> stringSanPhamList = ReadAndWriteFileToCSVC10.readFileSanPham(SAN_PHAM);
        List<SanPham> sanPhamList = ReadAndWriteFileToCSVC10.chuyenStringListSangSanPhamList(stringSanPhamList);
        boolean kiemtra = true;
        System.out.print("Nhập mã sản phẩm hoặc tên sản phẩm cần tìm kiếm: ");
        String noiDungTimKiem = scanner.nextLine();
        for (SanPham sanPham:sanPhamList){
            if (sanPham.getMaSanPham().toLowerCase().contains(noiDungTimKiem.toLowerCase())
                    ||sanPham.getTenSanPham().toLowerCase().contains(noiDungTimKiem.toLowerCase())){
                System.out.println("Sản phẩm cần tìm kiếm: ");
                System.out.println(sanPham);
                kiemtra = false;
            }
        }
        if (kiemtra){
            System.out.println("Mã sản phẩm hoặc tên sản phẩm bạn nhập không tìm thấy trong danh sách!!");
        }
    }
}
