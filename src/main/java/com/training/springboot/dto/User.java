package com.training.springboot.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @JsonIgnore
    private Long userId;

    @NotBlank(message = "Email ID should not be empty")
    private String email;

    @NotNull(message = "Date of birth should not be empty")
    private LocalDate dateOfBirth;

    @NotBlank(message = "Gender should not be empty")
    private String gender;

    @Min(value = 0, message = "Salary should be greater than 0")
    private BigDecimal salary;

    private Address address;

}
