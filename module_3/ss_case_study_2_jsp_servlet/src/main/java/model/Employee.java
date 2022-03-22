package model;

public class Employee extends Person {
    private String employeeCode;
    private Integer degreeCode;
    private Integer positionCode;
    private Integer divisionCode;
    private Double salary;

    public Employee() {
    }

    public Employee(String employeeCode, Integer degreeCode, Integer positionCode, Integer divisionCode, Double salary) {
        this.employeeCode = employeeCode;
        this.degreeCode = degreeCode;
        this.positionCode = positionCode;
        this.divisionCode = divisionCode;
        this.salary = salary;
    }

    public Employee(String name, String dateOfBirth, String IDNumber, String phoneNumber, String email, String address, String employeeCode, Integer degreeCode, Integer positionCode, Integer divisionCode, Double salary) {
        super(name, dateOfBirth, IDNumber, phoneNumber, email, address);
        this.employeeCode = employeeCode;
        this.degreeCode = degreeCode;
        this.positionCode = positionCode;
        this.divisionCode = divisionCode;
        this.salary = salary;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public Integer getDegreeCode() {
        return degreeCode;
    }

    public void setDegreeCode(Integer degreeCode) {
        this.degreeCode = degreeCode;
    }

    public Integer getPositionCode() {
        return positionCode;
    }

    public void setPositionCode(Integer positionCode) {
        this.positionCode = positionCode;
    }

    public Integer getDivisionCode() {
        return divisionCode;
    }

    public void setDivisionCode(Integer divisionCode) {
        this.divisionCode = divisionCode;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeCode='" + employeeCode + '\'' +
                ", degreeCode=" + degreeCode +
                ", positionCode=" + positionCode +
                ", divisionCode=" + divisionCode +
                ", salary=" + salary +
                ", name='" + name + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", IDNumber='" + IDNumber + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
