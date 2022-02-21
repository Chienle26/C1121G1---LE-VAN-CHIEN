package ss_de_thi_that_c11.de_thi_c11.controllers;

import ss_de_thi_that_c11.de_thi_c11.services.BenhAnService;
import ss_de_thi_that_c11.de_thi_c11.services.BenhAnServiceImpl;

import java.util.Scanner;

public class BenhAnController {
    static Scanner scanner = new Scanner(System.in);
    static BenhAnService benhAnService = new BenhAnServiceImpl();

    public static void main(String[] args) {
        danhSachChuongTrinhChinh();
    }

    public static void danhSachChuongTrinhChinh() {
        boolean kiemTra = true;
        do {
            try {
                System.out.println("--CHƯƠNG TRÌNH QUẢN LÝ BỆNH ÁN --\n" +
                        "Chọn chức năng theo số (để tiếp tục):\n" +
                        "1. Thêm mới\n" +
                        "2. Xóa\n" +
                        "3. Xem danh sách các sản phẩm\n" +
                        "4. Thoát\n");
                System.out.print("Chọn chức năng: ");
                int chonChucNang = Integer.parseInt(scanner.nextLine());
                switch (chonChucNang) {
                    case 1:
                        themMoiBenhAn();
                        break;
                    case 2:
                        while (true) {
                            try {
                                benhAnService.xoa();
                                break;
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                        }
                        break;
                    case 3:
                        benhAnService.hienThi();
                        break;
                    case 4:
                        kiemTra = false;
                        break;
                    default:
                        System.out.println("Nhập sai. Hãy nhập lại!");
                }
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        } while (kiemTra);
    }

    public static void themMoiBenhAn() {
        boolean kiemTra = true;
        do {
            try {
                System.out.println("Chọn loại bệnh án cần thêm mới:");
                System.out.println("1. Bệnh Án của bệnh nhân thường");
                System.out.println("2. Bệnh Án của bệnh nhân VIP");
                System.out.println("3. Quay lại quản lý bệnh án");
                System.out.print("Chọn loại bệnh án: ");
                int chonBenhAn = Integer.parseInt(scanner.nextLine());
                switch (chonBenhAn) {
                    case 1:
                        benhAnService.themMoi(1);
                        break;
                    case 2:
                        benhAnService.themMoi(2);
                        break;
                    case 3:
                        kiemTra = false;
                        break;
                    default:
                        System.out.println("Nhập sai. Hãy nhập lại!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Nhập sai định dạng. Hãy nhập lại");
            }
        } while (kiemTra);
    }
}
