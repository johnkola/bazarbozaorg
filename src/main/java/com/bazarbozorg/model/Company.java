package com.bazarbozorg.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name = "companies")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Company extends BasePojo {

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Company registration number is required")
    @Column(unique = true, nullable = false)
    private String registrationNumber;

    @NotBlank(message = "Industry is required")
    private String industry;
}