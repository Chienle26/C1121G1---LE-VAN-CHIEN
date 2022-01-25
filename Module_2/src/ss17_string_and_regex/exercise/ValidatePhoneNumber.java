package ss17_string_and_regex.exercise;

public class ValidatePhoneNumber {
    public static void main(String[] args) {
        String regex = "^\\([0-9]{2}\\)-\\([0][0-9]{9}\\)$";
        String[] phoneNumber = {"84-0978489648", "a8-22222222"};
        String[] phoneNumber2 = {"(84)-(0978489648)", "(a8)-(22222222)","(89)-(0022222222)","84-0122222222","84012222222"};
        for (String phone : phoneNumber2) {
            boolean isPhoneNumber = phone.matches(regex);
            System.out.println(phone + ": " + isPhoneNumber);
        }
    }
}
