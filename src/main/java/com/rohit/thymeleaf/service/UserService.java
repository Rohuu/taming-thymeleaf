package com.rohit.thymeleaf.service;

import com.rohit.thymeleaf.configuration.CreateUserParameters;
import com.rohit.thymeleaf.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    User createUser(CreateUserParameters parameters);
    Page<User> findAll(Pageable pageable);
}
