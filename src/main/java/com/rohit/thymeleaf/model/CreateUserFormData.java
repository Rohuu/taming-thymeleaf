package com.rohit.thymeleaf.model;

import com.rohit.thymeleaf.configuration.CreateUserParameters;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserFormData {
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotNull
    private Gender gender;
    @Email
    @NotBlank
    private String email;
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;
    @NotBlank
    @Pattern(regexp = "[0-9.\\-() x/+]+")
    private String phoneNumber;

    public CreateUserParameters toParameters() {
        return new CreateUserParameters(
                new UserName(firstName,lastName),
                gender,
                birthday,
                new com.rohit.thymeleaf.model.Email(email),
                new PhoneNumber(phoneNumber));
    }
}
