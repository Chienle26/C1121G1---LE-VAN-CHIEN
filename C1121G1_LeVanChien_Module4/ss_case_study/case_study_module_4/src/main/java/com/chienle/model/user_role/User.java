package com.chienle.model.user_role;

import com.chienle.model.employee.Employee;

import javax.persistence.*;
import java.util.Set;

@Entity
public class User {

    @Id
    private String userName;

    private String password;

    @OneToMany(mappedBy = "user")
    private Set<UserRole> userRoles;

    @OneToOne(mappedBy = "user")
    private Employee employee;

    public User() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
