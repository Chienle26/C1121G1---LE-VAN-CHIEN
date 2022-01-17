package ss0_my_project;

import java.util.Scanner;

public class DiemTrungBinhMonTV5 {
    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            double diemNoi;
            double diemViet;
            double diemTrungBinh;

            System.out.print("Nhập điểm nói: ");
            diemNoi = Double.parseDouble(scanner.nextLine());
            System.out.print("Nhập điểm viết: ");
            diemViet = Double.parseDouble(scanner.nextLine());

            diemTrungBinh = Math.round((diemNoi + diemViet) / 2);
            System.err.println("Điểm trung bình là: " + diemTrungBinh);
            System.out.println("======================");
        }
    }
}
