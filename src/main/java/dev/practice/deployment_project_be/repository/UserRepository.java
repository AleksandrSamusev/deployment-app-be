package dev.practice.deployment_project_be.repository;

import dev.practice.deployment_project_be.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Long, User> {

}
