package com.rohit.thymeleaf.repository;

import com.rohit.thymeleaf.model.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.LocalDate;
import java.time.Month;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@AutoConfigureTestDatabase
@DataJpaTest
class UserRepositoryTest {

    private final UserRepository repository;
    private final JdbcTemplate jdbcTemplate;
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    UserRepositoryTest(UserRepository repository, JdbcTemplate jdbcTemplate) {
        this.repository = repository;
        this.jdbcTemplate = jdbcTemplate;
    }

    @BeforeEach
    void validatePreconditions() {
        assertThat(repository.count()).isZero();
    }

    @Test
    void testSaveUser() {
        UUID id = UUID.randomUUID();
        User user = new User(id, new UserName("Rohit", "Bhandari"), Gender.MALE, LocalDate.of(1997, Month.FEBRUARY, 21), new Email("rohuu99022@gmail.com"), new PhoneNumber("1234567890"));

        repository.save(user);
        entityManager.flush();

        String fName = jdbcTemplate.queryForObject("select first_name from users", String.class);
        assertThat(fName).isEqualTo(user.getUserName().getFirstName());

        String lName = jdbcTemplate.queryForObject("select last_name from users", String.class);
        assertThat(lName).isEqualTo(user.getUserName().getLastName());

        Gender gender = jdbcTemplate.queryForObject("select gender from users", Gender.class);
        assertThat(gender).isEqualTo(user.getGender());

        LocalDate date = jdbcTemplate.queryForObject("select birthday from users", LocalDate.class);
        assertThat(date).isEqualTo(user.getBirthday());

        Email email = jdbcTemplate.queryForObject("select email from users", Email.class);
        assertThat(email).isEqualTo(user.getEmail());

        PhoneNumber phoneNumber = jdbcTemplate.queryForObject("select phone_number from users", PhoneNumber.class);
        assertThat(phoneNumber).isEqualTo(user.getPhoneNumber());
    }


    @Test
    void shouldBeAbleToGiveAPageByPageableObject() {
        saveUsers(8);
        Sort sort=Sort.by(Sort.Direction.ASC,"userName.lastName","userName.firstName");

        assertThat(repository.findAll
                (PageRequest.of(0,5,sort)))
                .hasSize(5)
                .extracting(user -> user.getUserName().getFullName())
                .containsExactly("Tommy0 Halt","Tommy2 Halt","Tommy4 Halt","Tommy6 Halt","Tommy1 Walton");

        assertThat(repository.findAll
                (PageRequest.of(1,5,sort)))
                .hasSize(3)
                .extracting(user -> user.getUserName().getFullName())
                .containsExactly("Tommy3 Walton","Tommy5 Walton","Tommy7 Walton");

        assertThat(repository.findAll
                (PageRequest.of(2,5,sort))).isEmpty();
    }

    private void saveUsers(int totalUser) {
        for (int i = 0; i < totalUser; i++) {
            repository.save(
                    new User(UUID.randomUUID(), new UserName("Tommy"+i, (i%2==0)?"Halt":"Walton"), Gender.MALE, LocalDate.of(2012, 01, 17), new Email("tommy.Holt1@gmail.com"), new PhoneNumber("1234567890")));
        }
    }
}