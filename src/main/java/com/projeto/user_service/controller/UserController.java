package com.projeto.user_service.controller;

import com.projeto.user_service.model.User;
import com.projeto.user_service.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service){
        this.service = service;
    }

    @GetMapping
    public List<User> listarUsuarios(){
        return service.listarUsuarios();
    }

    @PostMapping
    public User criarUsuario(@RequestBody User user){
        return service.salvarUsuario(user);
    }
}
