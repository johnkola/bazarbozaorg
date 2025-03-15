package com.bazarbozorg.model;

import com.bazarbozorg.model.types.ContactTypeList;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name = "contact_info")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContactInfo extends BasePojo { // Now extends BasePojo


    @Enumerated(EnumType.STRING)
    private ContactTypeList type;

    @NotBlank(message = "Contact detail is required")
    private String detail;
}