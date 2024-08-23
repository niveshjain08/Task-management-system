package com.example.TaskManagementSystem.repository;

import com.example.TaskManagementSystem.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmailId(String emailId);

    User findByEmailIdAndPassword(String emailId, String password);
}
