package com.example.Spectro.entities;


import com.example.Spectro.enums.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name = "users_table")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true, nullable = false)
    @NotBlank(message = "Email is required")
    @Email(message = "Please enter a valid email address")
    private String email ;
    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;


}
