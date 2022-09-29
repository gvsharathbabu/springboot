package com.training.springboot.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @JsonIgnore
    private Long addressId;

    @NotBlank(message = "Street should not be empty")
    private String street;

    @NotBlank(message = "City should not be empty")
    private String city;

    @NotBlank(message = "State should not be empty")
    private String state;

    @NotBlank(message = "Zipcode should not be empty")
    private String zipcode;

    @NotBlank(message = "Country should not be empty")
    private String country;
}
