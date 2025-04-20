package com.example.fintech.repository;

import com.example.fintech.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmailAndPassword(String email, String password);
    List<User> findByParentId(Long parentId);
    Optional<User> findById(Long id);
}
