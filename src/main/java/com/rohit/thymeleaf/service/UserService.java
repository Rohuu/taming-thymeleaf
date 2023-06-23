package com.rohit.thymeleaf.service;

import com.rohit.thymeleaf.configuration.CreateUserParameters;
import com.rohit.thymeleaf.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.Optional;
import java.util.UUID;

public interface UserService {
    User createUser(CreateUserParameters parameters);

    Page<User> findAll(Pageable pageable);

    User editUser(UUID id, EditUserParameters editUserParameters) throws UserPrincipalNotFoundException;

    Optional<User> getUser(UUID id);

    void delete(UUID id);
}
