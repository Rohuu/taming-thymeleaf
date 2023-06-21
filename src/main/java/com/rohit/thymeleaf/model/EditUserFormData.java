package com.rohit.thymeleaf.model;

import com.rohit.thymeleaf.service.EditUserParameters;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;


@EqualsAndHashCode(callSuper = true)
@Data
public class EditUserFormData extends CreateUserFormData{
    private UUID id;

    public static EditUserFormData fromUser(User user){
        EditUserFormData result=new EditUserFormData();
        result.setId(user.getId());
        result.setFirstName(user.getUserName().getFirstName());
        result.setLastName(user.getUserName().getLastName());
        result.setGender(user.getGender());
        result.setBirthday(user.getBirthday());
        result.setEmail(user.getEmail().asString());
        result.setPhoneNumber(user.getPhoneNumber().asString());
        return result;
    }

    public EditUserParameters toParameters(){
        return new EditUserParameters(
                new UserName(getFirstName(),getLastName()),
                getGender(),
                getBirthday(),
                new Email(getEmail()),
                new PhoneNumber(getPhoneNumber())
        );
    }
}
