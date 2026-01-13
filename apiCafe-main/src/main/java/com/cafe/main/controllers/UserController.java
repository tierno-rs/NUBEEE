package com.cafe.main.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*; // Simplifica las importaciones
import com.cafe.main.models.UserModel;
import com.cafe.main.services.UserService;

@RestController
@RequestMapping(path = "user")
@CrossOrigin(origins = "http://localhost:4200") // 1. Agrega esto para permitir Angular
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getAll")
    public List<UserModel> getAll() {
        return userService.getUsers();
    }

    @GetMapping("/getOne/{id}")
    public UserModel getProduct(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @PostMapping("/save")
    public UserModel save(@RequestBody UserModel userModel) {
        return userService.createUser(userModel);
    }

    @PutMapping("/update/{id}")
    public UserModel update(@PathVariable int id, @RequestBody UserModel userModel) {
        return userService.updateUser(id, userModel);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id) {
        userService.deleteUser(id);
    }

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password) {
        // Este método será llamado por tu formulario morado de Login
        return userService.login(email, password);
    }
}