package com.bazarbozorg.model;

import com.bazarbozorg.enums.AutoTypeListConverter;
import com.bazarbozorg.model.types.RoleTypeList;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Set;


//@Entity
//@Table(name = "users")
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
public class User extends BasePojo {

    @OneToOne
    @JoinColumn(name = "person_id", unique = true)
    private Person person; // Explicit reference to Person

    @OneToOne
    @JoinColumn(name = "company_id", unique = true)
    private Company company; // Explicit reference to Company

    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "Password must be at least 6 characters")
    private String password;

    @AutoTypeListConverter
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RoleTypeList role;

    @OneToMany(mappedBy = "individual", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ContactInfo> contactInfos;

    @OneToMany(mappedBy = "individual", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Address> addresses;
}
