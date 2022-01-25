package ss17_string_and_regex.exercise;

public class ValidateClassName {
    public static void main(String[] args) {
        String regex = "^[CAP][0-9]{4}[G-M]$";
        String[] className = {"C0318G", "M0318G", "P0323A"};
        for (String element : className) {
            boolean isClassName = element.matches(regex);
            System.out.println(element + ": " + isClassName);
        }
    }
}
