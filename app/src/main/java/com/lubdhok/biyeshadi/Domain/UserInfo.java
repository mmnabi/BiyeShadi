package com.lubdhok.biyeshadi.Domain;

import java.io.Serializable;

/**
 * Created by PrinceOfNightmareH on 29-Dec-17.
 */

public class UserInfo implements Serializable {
    private String fullName, address, division, mobile, email;
    private int age;
    private char gender;

    public UserInfo(String fullName, String address, String division, String mobile, String email, int age, char gender) {
        this.fullName = fullName;
        this.address = address;
        this.division = division;
        this.mobile = mobile;
        this.email = email;
        this.age = age;
        this.gender = gender;
    }

    public String getFullName() {
        return fullName;
    }

    public String getAddress() {
        return address;
    }

    public String getDivision() {
        return division;
    }

    public String getMobile() {
        return mobile;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public char getGender() {
        return gender;
    }
}
