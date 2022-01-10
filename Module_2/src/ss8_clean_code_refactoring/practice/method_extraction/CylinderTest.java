package ss8_clean_code_refactoring.practice.method_extraction;

class CylinderTest {
    public static void main(String[] args) {
        Cylinder cylinder = new Cylinder();
        System.out.println("Volume: " + cylinder.getVolume(5, 5));
        System.out.println("Volume: " + cylinder.getVolume(1, 1));
        System.out.println("Volume: " + cylinder.getVolume(2, 3));
    }

}
