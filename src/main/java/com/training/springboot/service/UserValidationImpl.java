package com.training.springboot.service;

import com.training.springboot.dto.User;
import com.training.springboot.exceptions.UnableToProcessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

import static com.training.springboot.constants.Messages.*;

@Service
@Slf4j
public class UserValidationImpl implements UserValidation {
    @Override
    public String validateUser(User user) {
        log.info("entry : validateUser");

        if (user != null) {
            if (Period.between(user.getDateOfBirth(), LocalDate.now()).getYears() < 18) {
                log.error(BIRTH_DATE_INVALID);
                throw new UnableToProcessException(BIRTH_DATE_INVALID);
            }
            log.info(USER_VALID);
            return USER_VALID;
        }
        log.error(USER_INVALID);
        throw new UnableToProcessException(USER_INVALID);
    }
}
