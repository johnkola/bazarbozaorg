package com.bazarbozorg.entity;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;

//@Entity
//@Table(name = "addresses")
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
public class Address extends BasePojo { // Now extends BasePojo

    @ManyToOne
    @JoinColumn(name = "individual_id", nullable = false)
    private BasePojo individual; // References either Person or Company

    @NotBlank(message = "Street is required")
    private String street;

    @NotBlank(message = "City is required")
    private String city;

    @NotBlank(message = "State is required")
    private String state;

    @NotBlank(message = "Postal code is required")
    private String postalCode;

    @NotBlank(message = "Country is required")
    private String country;
}