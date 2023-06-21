package com.rohit.thymeleaf.service;

import com.rohit.thymeleaf.configuration.CreateUserParameters;
import com.rohit.thymeleaf.model.*;

import java.time.LocalDate;

public class EditUserParameters extends CreateUserParameters {

    public EditUserParameters(UserName userName, Gender gender, LocalDate birthday, Email email, PhoneNumber phoneNumber) {
        super(userName, gender, birthday, email, phoneNumber);
    }


    public void update(User user) {
        user.setUserName(getUserName());
        user.setGender(getGender());
        user.setBirthday(getBirthday());
        user.setEmail(getEmail());
        user.setPhoneNumber(getPhoneNumber());
    }
}
