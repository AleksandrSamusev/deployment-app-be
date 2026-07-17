package dev.practice.deployment_project_be.service;

import dev.practice.deployment_project_be.dtos.SignupDto;
import dev.practice.deployment_project_be.dtos.UserResponseDto;
import dev.practice.deployment_project_be.dtos.UserUpdateDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    UserResponseDto createUser(SignupDto dto);
    Page<UserResponseDto> getAllUsers(Pageable pageable);
    UserResponseDto getUserById(Long userId);
    UserResponseDto updateUser(Long userId, UserUpdateDto dto);
    void deleteUser(Long userId);
}
