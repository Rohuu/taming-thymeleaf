package com.rohit.thymeleaf.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class UserName {
    String firstName;
    String lastName;

}
