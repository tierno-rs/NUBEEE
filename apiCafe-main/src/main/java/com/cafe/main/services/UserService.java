package com.cafe.main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe.main.models.UserModel;
import com.cafe.main.repositories.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    public List<UserModel> getUsers(){
        return userRepository.findAll();
    }
    public UserModel getUserById(int id){
        return userRepository.findById(id).orElse(null);
    }
    public UserModel createUser(UserModel user){
        return userRepository.save(user);
    }
    public UserModel updateUser(int id, UserModel user){
        UserModel existingUser = userRepository.findById(id).orElse(null);
        if(existingUser != null){
            existingUser.setUsername(user.getUsername());
            existingUser.setEmail(user.getEmail());
            existingUser.setPhone(user.getPhone());
            return userRepository.save(existingUser);
        }
        return null;
    }
    public void deleteUser(int id){
        userRepository.deleteById(id);
    }

    public String login(String email, String password) {
        return userRepository.findByEmail(email).map(user -> {
            if (user.getPassword().equals(password)) {
                return "Login exitoso";
            } else {
                return "Contraseña incorrecta";
            }
        }).orElse("Usuario no encontrado");
    }

}
