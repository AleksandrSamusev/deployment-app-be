package dev.practice.deployment_project_be.service;

import dev.practice.deployment_project_be.dtos.SignupDto;
import dev.practice.deployment_project_be.dtos.UserResponseDto;
import dev.practice.deployment_project_be.dtos.UserUpdateDto;
import dev.practice.deployment_project_be.mappers.UserMapper;
import dev.practice.deployment_project_be.models.User;
import dev.practice.deployment_project_be.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@AllArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    @Transactional
    public UserResponseDto createUser(SignupDto dto) {
        User savedUser = userRepository.save(userMapper.toUser(dto));
        log.info("User saved with id {}", savedUser.getUserId());
        return userMapper.toUserResponse(savedUser);
    }

    @Override
    public Page<UserResponseDto> getAllUsers(Pageable pageable) {
        return userRepository.findAll(pageable).map(userMapper::toUserResponse);
    }

    @Override
    public UserResponseDto getUserById(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException("User not found with given id: " +  userId + "!"));
        log.info("Retrieved user with id {} ", userId);
        return userMapper.toUserResponse(user);
    }

    @Override
    @Transactional
    public UserResponseDto updateUser(Long userId, UserUpdateDto dto) {
        User user = userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException("User not found with given id: " +  userId + "!"));
        userMapper.toUser(user, dto);
        User savedUser = userRepository.save(user);
        log.info("User with id: {} updated successfully!", userId);
        return userMapper.toUserResponse(savedUser);
    }

    @Override
    @Transactional
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
        log.info("User with id {} successfully deleted!", userId);
    }
}
