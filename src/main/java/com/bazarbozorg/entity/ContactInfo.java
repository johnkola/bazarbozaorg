package com.bazarbozorg.entity;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;

enum ContactType {
    EMAIL,
    PHONE
}

//@Entity
//@Table(name = "contact_info")
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
public class ContactInfo extends BasePojo { // Now extends BasePojo


    @Enumerated(EnumType.STRING)
    private ContactType type;

    @NotBlank(message = "Contact detail is required")
    private String detail;
}