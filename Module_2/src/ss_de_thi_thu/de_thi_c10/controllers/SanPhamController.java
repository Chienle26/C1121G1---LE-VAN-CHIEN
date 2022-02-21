package ss_de_thi_thu.de_thi_c10.controllers;

import ss_de_thi_thu.de_thi_c10.services.SanPhamService;
import ss_de_thi_thu.de_thi_c10.services.SanPhamServiceImpl;

import java.util.Scanner;

public class SanPhamController {
    static Scanner scanner = new Scanner(System.in);
    static SanPhamService sanPhamService = new SanPhamServiceImpl();

    public static void main(String[] args) {
        danhSachChuongTrinhChinh();
    }

    public static void danhSachChuongTrinhChinh() {
        boolean kiemTra = true;
        do {
            try {
                System.out.println("--CHƯƠNG TRÌNH QUẢN LÝ SẢN PHẨM –\n" +
                        "Chọn chức năng theo số (để tiếp tục):\n" +
                        "1. Thêm mới\n" +
                        "2. Xóa\n" +
                        "3. Xem danh sách các sản phẩm\n" +
                        "4. Tìm kiếm\n" +
                        "5. Thoát\n");
                System.out.print("Chọn chức năng: ");
                int chonChucNang = Integer.parseInt(scanner.nextLine());
                switch (chonChucNang) {
                    case 1:
                        themMoiSanPham();
                        break;
                    case 2:
                        while (true) {
                            try {
                                sanPhamService.xoa();
                                break;
                            } catch (Exception e) {
                                System.out.println("Không tìm thấy!!! Hãy nhập lại!!!");
                            }
                        }
                        break;
                    case 3:
                        sanPhamService.hienThi();
                        break;
                    case 4:
                        sanPhamService.timKiem();
                        break;
                    case 5:
                        kiemTra = false;
                        break;
                    default:
                        System.out.println("Nhập sai!!! Hãy nhập lại!");
                }
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        } while (kiemTra);
    }

    public static void themMoiSanPham() {
        boolean kiemTra = true;
        do {
            try {
                System.out.println("Chọn loại sản phẩm cần thêm mới:");
                System.out.println("1. Sản phẩm nhập khẩu");
                System.out.println("2. Sản phẩm xuất khẩu");
                System.out.println("3. Quay lại quản lý sản phẩm");
                System.out.print("Chọn loại sản phẩm: ");
                int chonSanPham = Integer.parseInt(scanner.nextLine());
                switch (chonSanPham) {
                    case 1:
                        sanPhamService.themMoi(1);
                        break;
                    case 2:
                        sanPhamService.themMoi(2);
                        break;
                    case 3:
                        kiemTra = false;
                        break;
                    default:
                        System.out.println("Nhập sai!!! Hãy nhập lại!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Nhập sai định dạng!!! Hãy nhập lại");
            }
        } while (kiemTra);
    }
}
