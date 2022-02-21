package ss_de_thi_that_c11.de_thi_c11.services;

import ss_de_thi_that_c11.de_thi_c11.models.BenhAn;
import ss_de_thi_that_c11.de_thi_c11.models.BenhAnThuong;
import ss_de_thi_that_c11.de_thi_c11.models.BenhAnVip;
import ss_de_thi_that_c11.de_thi_c11.utils.NotFoundProductException;
import ss_de_thi_that_c11.de_thi_c11.utils.ReadAndWriteFileToCSVC11;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BenhAnServiceImpl implements BenhAnService {
    static final String BENH_AN = "src/ss_de_thi_that_c11/de_thi_c11/data/BenhAn.csv";
    Scanner scanner = new Scanner(System.in);

    @Override
    public void themMoi(int luaChonSanPhamThemMoi) {
        List<BenhAn> benhAnThuongList = new ArrayList<>();
        List<BenhAn> benhAnVipList = new ArrayList<>();
        List<String> stringBenhAnThuongList;
        List<String> stringBenhAnVipList;

        System.out.print("Nhập mã bệnh án: ");
        String maBenhAn = scanner.nextLine();
        System.out.print("Nhập mã bệnh án: ");
        String tenBenhAn = scanner.nextLine();
        System.out.print("Nhập tên bệnh nhân: ");
        String tenBenhNhan = scanner.nextLine();
        System.out.print("Nhập ngày nhập viện: ");
        String ngayNhapVien = scanner.nextLine();
        System.out.print("Nhập ngày ra viện: ");
        String ngayRaVien = scanner.nextLine();
        System.out.print("Nhập lý do nhập viện: ");
        String lyDoNhapVien = scanner.nextLine();
        switch (luaChonSanPhamThemMoi) {
            case 1:
                System.out.print("Nhập phí nhập viện: ");
                double phiNhapVien = Double.parseDouble(scanner.nextLine());
                benhAnThuongList = new ArrayList<>();
                BenhAnThuong benhAnThuong = new BenhAnThuong(maBenhAn, tenBenhAn, tenBenhNhan, ngayNhapVien, ngayRaVien, lyDoNhapVien, phiNhapVien);
                benhAnThuongList.add(benhAnThuong);
                stringBenhAnThuongList = ReadAndWriteFileToCSVC11.chuyenBenhAnListSangStringList(benhAnThuongList);
                ReadAndWriteFileToCSVC11.writeFileToBenhAn(BENH_AN, stringBenhAnThuongList, true);
                System.out.println("Thêm mới thành công bệnh án của bệnh nhân VIP!");
                break;
            case 2:
                System.out.print("Nhập loại VIP: ");
                String loaiVip = scanner.nextLine();
                System.out.print("Nhập thời hạn VIP: ");
                String thoiHanVip = scanner.nextLine();
                benhAnVipList = new ArrayList<>();
                BenhAnVip benhAnVip = new BenhAnVip(maBenhAn, tenBenhAn, tenBenhNhan, ngayNhapVien, ngayRaVien, lyDoNhapVien, loaiVip, thoiHanVip);
                benhAnVipList.add(benhAnVip);
                stringBenhAnVipList = ReadAndWriteFileToCSVC11.chuyenBenhAnListSangStringList(benhAnVipList);
                ReadAndWriteFileToCSVC11.writeFileToBenhAn(BENH_AN, stringBenhAnVipList, true);
                System.out.println("Thêm mới thành công bệnh án của bệnh nhân thường!");
                break;
        }
    }

    @Override
    public void xoa() {
        List<String> stringBenhAnList = ReadAndWriteFileToCSVC11.readFileBenhAn(BENH_AN);
        List<BenhAn> benhAnList = ReadAndWriteFileToCSVC11.chuyenStringListSangBenhAnList(stringBenhAnList);
        System.out.print("Nhập mã bệnh án cần xóa: ");
        String maBenhAnCanXoa = scanner.nextLine();
        Boolean kiemtra = true;
        for (BenhAn sanPham : benhAnList) {
            if (sanPham.getMaBenhAn().equals(maBenhAnCanXoa)) {
                try {
                    System.out.println("Bạn có chắc xóa bệnh án này không?");
                    System.out.println("1.Có");
                    System.out.println("2.Không");
                    System.out.print("Bạn chọn: ");
                    kiemtra = false;
                    int luaChonXoa = Integer.parseInt(scanner.nextLine());
                    switch (luaChonXoa) {
                        case 1:
                            benhAnList.remove(sanPham);
                            stringBenhAnList = ReadAndWriteFileToCSVC11.chuyenBenhAnListSangStringList(benhAnList);
                            ReadAndWriteFileToCSVC11.writeFileToBenhAn(BENH_AN, stringBenhAnList, false);
                            hienThi();
                            break;
                        case 2:
                            System.out.println("Đã hủy xóa!");
                            break;
                        default:
                            throw new NotFoundProductException("Bạn nhập không đúng!");
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        if (kiemtra) {
            System.out.println("Không tìm thấy sản phẩm cần xóa!!!");
//            throw new NotFoundProductException("Không tìm thấy sản phẩm cần xóa!!!");
        }
    }

    @Override
    public void hienThi() {
        List<String> stringList = ReadAndWriteFileToCSVC11.readFileBenhAn(BENH_AN);
        List<BenhAn> benhAnList = ReadAndWriteFileToCSVC11.chuyenStringListSangBenhAnList(stringList);
        System.out.println("Danh Sách bệnh án: ");
        for (BenhAn benhAn : benhAnList) {
            System.out.println(benhAn);
        }
    }

}
