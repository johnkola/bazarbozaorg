package com.bazarbozorg.model;

import com.bazarbozorg.model.types.GenderTypeList;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name = "persons")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Person extends BasePojo {

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Last name is required")
    private String lastName;

    @Min(value = 18, message = "Age must be at least 18")
    @Max(value = 100, message = "Age must be less than 100")
    private int age;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private GenderTypeList gender;
    @Id
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}