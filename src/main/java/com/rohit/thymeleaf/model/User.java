package com.rohit.thymeleaf.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@Entity
@Table(name = "users")
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue
    UUID id;
    @NotNull
    private UserName userName;
    @NotNull
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @NotNull
    private LocalDate birthday;
    @NotNull
    private Email email;
    @NotNull
    private PhoneNumber phoneNumber;
}
