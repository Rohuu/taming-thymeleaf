package com.rohit.thymeleaf.model;

import lombok.Data;

@Data
public class Email {
    private String email;

    public Email(String email) {
        this.email = email;
    }

    public String asString() {
        return email;
    }
}
