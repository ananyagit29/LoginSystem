package com.example.login_backend.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.login_backend.entity.DmsUser;
import com.example.login_backend.repository.UserRepository;

@Service
@Transactional
public class AuthService {

    private final UserRepository repo;

    public AuthService(UserRepository repo) {
        this.repo = repo;
    }

    public String login(String userId, String password) {

        DmsUser user = repo.findById(userId).orElse(null);

        if (user == null) {
            return "User Not Found";
        }

        if ("INACTIVE".equalsIgnoreCase(user.getActiveStatus())) {
            return "Account Locked";
        }

        // SUCCESS LOGIN
        if (user.getPassword().equals(password)) {

            user.setFailedAttempts(0);
            repo.save(user);

            return "SUCCESS";
        }

        // FAILED LOGIN
        int attempts = user.getFailedAttempts() != null ? user.getFailedAttempts() : 0;

        attempts++;

        user.setFailedAttempts(attempts);

        if (attempts >= 3) {
            user.setActiveStatus("INACTIVE");
        }

        repo.save(user);

        return "Invalid Credentials";
    }
}
