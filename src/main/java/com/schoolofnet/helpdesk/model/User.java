package com.schoolofnet.helpdesk.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.util.Set;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    // Validação física: OK
    @Column(nullable = false, unique = true)
    // Validação de bean: questionável
    @NotEmpty(message = "Cannot be blank")
    @Email
    private String email;
    @Column
    // Validação de bean: questionável
    @NotEmpty(message = "Cannot be blank")
    private String name;
    @Column
    // Validação de bean: questionável
    @NotEmpty(message = "Cannot be blank")
    private String lastName;
    @Column
    // Validação de bean: questionável
    @NotEmpty(message = "Cannot be blank")
    @Length(min = 5, message = "Must be at least 5 characters long")
    private String password;
    @Column
    private Boolean active = true;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;
}
