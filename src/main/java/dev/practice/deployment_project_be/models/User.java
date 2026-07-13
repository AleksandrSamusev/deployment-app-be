package dev.practice.deployment_project_be.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "first_name")
    @NotBlank(message = "First name cannot be blank")
    private String firstName;
    @Column(name = "last_name")
    @NotBlank(message = "Last name cannot be blank")
    private String lastName;
    @Column(name = "email", unique = true)
    @NotBlank(message = "Email cannot be blank")
    @Email(message="Email must be a valid format")
    private String email;
    @NotBlank(message = "password cannot be blank")
    @Column (name = "password")
    private String password;
}
