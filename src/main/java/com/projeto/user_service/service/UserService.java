package com.projeto.user_service.service;

import com.projeto.user_service.model.User;
import com.projeto.user_service.repository.UserRepository;

import java.util.List;

public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> listarUsuarios() {
        return repository.findAll();
    }

    public User salvarUsuario(User user) {
        return repository.save(user);
    }

}
