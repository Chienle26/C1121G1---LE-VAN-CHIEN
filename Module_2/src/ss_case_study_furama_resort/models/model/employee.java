package ss_case_study_furama_resort.models.model;

public class Employee extends Person {
    private String employeeCode;
    private String degree;
    private String position;
    private int salary;

    public Employee() {
    }

    public Employee(String employeeCode, String degree, String position, int salary) {
        this.employeeCode = employeeCode;
        this.degree = degree;
        this.position = position;
        this.salary = salary;
    }

    public Employee(String employeeCode, String name, String dateOfBirth, String gender, String IDNumber, String phoneNumber, String email, String degree, String position, int salary) {
        super(name, dateOfBirth, gender, IDNumber, phoneNumber, email);
        this.employeeCode = employeeCode;
        this.degree = degree;
        this.position = position;
        this.salary = salary;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String getInfor() {
        return this.employeeCode + "," + super.getInfor() + "," + this.degree + "," + this.position + "," + this.salary;
    }

    @Override
    public String toString() {
        return "employee{" +
                "employeeCode=" + employeeCode +
                ", name='" + name + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", gender='" + gender + '\'' +
                ", IDNumber=" + IDNumber +
                ", phoneNumber=" + phoneNumber +
                ", email='" + email + '\'' +
                ", degree='" + degree + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                '}';
    }
}
