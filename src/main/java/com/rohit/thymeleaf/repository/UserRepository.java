package com.rohit.thymeleaf.repository;

import com.rohit.thymeleaf.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Repository
@Transactional(readOnly= true)
public interface UserRepository extends CrudRepository<User, UUID>, PagingAndSortingRepository<User, UUID> {
}
