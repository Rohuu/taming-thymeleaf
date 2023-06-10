package com.rohit.thymeleaf.model;

import com.github.javafaker.Faker;
import lombok.Data;

@Data
public class PhoneNumber {
    private String phoneNumber;

    public PhoneNumber(String number) {
        this.phoneNumber=number;
    }

    public PhoneNumber(Faker phoneNumber) {

        this.phoneNumber = String.valueOf(phoneNumber);
    }

    public String asString() {
        return phoneNumber;
    }
}
