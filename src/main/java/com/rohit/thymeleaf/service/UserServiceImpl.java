package com.rohit.thymeleaf.service;

import com.google.common.collect.ImmutableSet;
import com.rohit.thymeleaf.configuration.CreateUserParameters;
import com.rohit.thymeleaf.model.User;
import com.rohit.thymeleaf.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(CreateUserParameters parameters) {
        User user = new User(UUID.randomUUID(), parameters.getUserName(), parameters.getGender(), parameters.getBirthday(), parameters.getEmail(), parameters.getPhoneNumber());
        return userRepository.save(user);
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }
}
