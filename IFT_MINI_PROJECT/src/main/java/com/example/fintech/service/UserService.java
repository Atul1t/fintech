package com.example.fintech.service;

import com.example.fintech.entity.User;
import com.example.fintech.entity.AccountType;
import com.example.fintech.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired private UserRepository repo;
    public User registerParent(User user) {
        user.setAccountType(AccountType.PARENT);
        user.setAccountNumber(generateAccountNumber());
        return repo.save(user);
    }

    public User createChild(User child, User parent) {
        child.setAccountType(AccountType.CHILD);
        child.setParent(parent);
        child.setAccountNumber(generateAccountNumber());
        return repo.save(child);
    }

    public Optional<User> authenticate(String e, String p) { return repo.findByEmailAndPassword(e, p); }
    public List<User> getChildren(Long pid) { return repo.findByParentId(pid); }
    public Optional<User> findById(Long id) {
        return repo.findById(id);
    }
    private String generateAccountNumber() {
        return String.valueOf((int)(Math.random() * 900000) + 100000); // 6-digit random
    }
    public List<User> findChildrenByParentId(Long parentId) {
        return repo.findByParentId(parentId);
    }


}
