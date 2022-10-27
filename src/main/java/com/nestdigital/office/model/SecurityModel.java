package com.nestdigital.office.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="security_data")
public class SecurityModel {
    @Id
    @GeneratedValue
    private int id;
    private int security_code;
    private String security_name;
    private String address;
    private String phone_number;
    private String dateofjoin;
    private String username;
    private String password;

    public SecurityModel(int id, int security_code, String security_name, String address, String phone_number, String dateofjoin, String username, String password) {
        this.id = id;
        this.security_code = security_code;
        this.security_name = security_name;
        this.address = address;
        this.phone_number = phone_number;
        this.dateofjoin = dateofjoin;
        this.username = username;
        this.password = password;
    }

    public SecurityModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSecurity_code() {
        return security_code;
    }

    public void setSecurity_code(int security_code) {
        this.security_code = security_code;
    }

    public String getSecurity_name() {
        return security_name;
    }

    public void setSecurity_name(String security_name) {
        this.security_name = security_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getDateofjoin() {
        return dateofjoin;
    }

    public void setDateofjoin(String dateofjoin) {
        this.dateofjoin = dateofjoin;
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
