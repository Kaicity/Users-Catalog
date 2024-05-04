package com.DisplayMakers.SpringAPI.service;

import com.DisplayMakers.SpringAPI.model.Users;
import com.DisplayMakers.SpringAPI.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository usersRepository;

    public Users registerUser(String login, String password, String email) {
        if (login == null || password == null) {
            return null;
        } else {
            Users users = new Users();
            users.setId(UUID.randomUUID().toString());
            users.setLogin(login);
            users.setEmail(email);
            users.setPassword(password);
            return usersRepository.save(users);
        }
    }
    public Users authenticate(String login, String password) {
        return usersRepository.findByLoginAndPassword(login, password).orElse(null);
    }
}
