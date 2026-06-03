package com.example.login_backend.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.login_backend.entity.DmsUser;
import com.example.login_backend.repository.UserRepository;

@Component
public class DataLoader implements CommandLineRunner {

    private final UserRepository repo;

    public DataLoader(UserRepository repo) {
        this.repo = repo;
    }

    @Override
    public void run(String... args) {
        
        if (repo.count() == 0) {

            DmsUser user1 = new DmsUser(
                    "ananya.parabat@ipca.com",
                    "ananya123",
                    "ACTIVE",
                    0
            );

            DmsUser user2 = new DmsUser(
                    "ruchita.saroj@ipca.com",
                    "ruchita123",
                    "ACTIVE",
                    0
            );

            repo.save(user1);
            repo.save(user2);

            System.out.println("Default users inserted successfully.");
        }
    }
}