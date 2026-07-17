package dev.practice.deployment_project_be.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto {
    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Email must be a valid format")
    private String email;
    @NotBlank(message = "password cannot be blank")
    private String password;
}
