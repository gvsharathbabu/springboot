package com.training.springboot;

import com.training.springboot.constants.Messages;
import com.training.springboot.dto.Address;
import com.training.springboot.dto.User;
import com.training.springboot.exceptions.UnableToProcessException;
import com.training.springboot.service.UserValidationImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;

@SpringBootTest
class SpringbootApplicationTests {

    @InjectMocks
    private UserValidationImpl userValidation;

    @Test
    void validScenario() {

        Address address = new Address(1L, "street",
                "city", "state", "zipcode", "country");

        User user = new User(1L, "test@email.com", LocalDate.of(1996, 6, 6), "M",
                new BigDecimal(100), address);
        Assertions.assertEquals(Messages.USER_VALID, userValidation.validateUser(user));
    }

    @Test
    void inValidAgeScenario() {

        Address address = new Address(1L, "street",
                "city", "state", "zipcode", "country");

        User user = new User(1L, "test@email.com", LocalDate.of(2022, 6, 6), "M",
                new BigDecimal(100), address);
        UnableToProcessException thrown = Assertions
                .assertThrows(UnableToProcessException.class,
                        () -> userValidation.validateUser(user),
                        Messages.BIRTH_DATE_INVALID);

        Assertions.assertEquals(Messages.BIRTH_DATE_INVALID, thrown.getMessage());
    }
}
