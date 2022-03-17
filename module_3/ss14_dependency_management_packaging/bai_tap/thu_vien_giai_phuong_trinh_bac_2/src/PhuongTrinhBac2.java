public class PhuongTrinhBac2 {

    public static double getDelta(double a, double b, double c) {
        return b * b - 4 * a * c;
    }

    public static double getNghiem1(double a, double b, double c) {
        if (getDelta(a,b,c) < 0) {
            return 0;
        } else {
            return (b + Math.pow(getDelta(a,b,c), 0.5)) / (2 * a);
        }
    }

    public static double getNghiem2(double a, double b, double c) {
        if (getDelta(a,b,c) < 0) {
            return 0;
        } else {
            return (-b - Math.pow(getDelta(a,b,c), 0.5)) / (2 * a);
        }
    }

    public static void getResult(double a, double b, double c) {
        if (getDelta(a,b,c) > 0) {
            System.out.println("Phương trình có 2 nghiệm:");
            System.out.println("Nghiệm thứ 1 :" + getNghiem1(a,b,c));
            System.out.println("Nghiệm thứ 2 :" + getNghiem2(a,b,c));
        } else if (getDelta(a,b,c) == 0) {
            System.out.println("Phương trình có nghiệm kép: " + getNghiem1(a,b,c));
        } else {
            System.out.println("Phương trình vô nghiệm");
        }
    }
}
