package com.nestdigital.office.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class OfficeModel {
    @Id
    @GeneratedValue

    private int id;
    private int employee_id;
    private String employee_name;
    private String employee_address;
    private String emp_dob;
    private String emp_dateofjoin;
    private String emp_email;
    private String username;
    private String password;

    public OfficeModel(int id, int employee_id, String employee_name, String employee_address, String emp_dob, String emp_dateofjoin, String emp_email, String username, String password) {
        this.id = id;
        this.employee_id = employee_id;
        this.employee_name = employee_name;
        this.employee_address = employee_address;
        this.emp_dob = emp_dob;
        this.emp_dateofjoin = emp_dateofjoin;
        this.emp_email = emp_email;
        this.username = username;
        this.password = password;
    }

    public OfficeModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public String getEmployee_address() {
        return employee_address;
    }

    public void setEmployee_address(String employee_address) {
        this.employee_address = employee_address;
    }

    public String getEmp_dob() {
        return emp_dob;
    }

    public void setEmp_dob(String emp_dob) {
        this.emp_dob = emp_dob;
    }

    public String getEmp_dateofjoin() {
        return emp_dateofjoin;
    }

    public void setEmp_dateofjoin(String emp_dateofjoin) {
        this.emp_dateofjoin = emp_dateofjoin;
    }

    public String getEmp_email() {
        return emp_email;
    }

    public void setEmp_email(String emp_email) {
        this.emp_email = emp_email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
