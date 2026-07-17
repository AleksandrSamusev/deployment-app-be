package dev.practice.deployment_project_be.mappers;

import dev.practice.deployment_project_be.dtos.LoginDto;
import dev.practice.deployment_project_be.dtos.SignupDto;
import dev.practice.deployment_project_be.dtos.UserResponseDto;
import dev.practice.deployment_project_be.models.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User toUser(SignupDto dto) {
        User user = new User();
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        return user;
    }

    public User toUser(LoginDto dto) {
        User user = new User();
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        return user;
    }

    public UserResponseDto toUserResponse(User user) {
        UserResponseDto dto = new UserResponseDto();
        dto.setUserId(user.getUserId());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setEmail(user.getEmail());
        return dto;
    }
}
