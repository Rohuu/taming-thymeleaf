package com.rohit.thymeleaf.configuration;

import com.rohit.thymeleaf.model.*;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CreateUserParameters {
    private UserName userName;
    private Gender gender;
    private LocalDate birthday;
    private Email email;
    private PhoneNumber phoneNumber;

    public CreateUserParameters(UserName userName, Gender gender, LocalDate birthday, Email email, PhoneNumber phoneNumber) {
        this.userName = userName;
        this.gender = gender;
        this.birthday = birthday;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public void update(User user) {
        user.setUserName(getUserName());
        user.setGender(getGender());
        user.setBirthday(getBirthday());
        user.setEmail(getEmail());
        user.setPhoneNumber(getPhoneNumber());
    }
}
