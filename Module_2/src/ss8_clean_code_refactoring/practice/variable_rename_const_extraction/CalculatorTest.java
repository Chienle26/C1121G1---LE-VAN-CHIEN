package ss8_clean_code_refactoring.practice.variable_rename_const_extraction;

class CalculatorTest {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println(calculator.calculate(2,3,'+'));
        System.out.println(calculator.calculate(3,7,'+'));
    }
}
