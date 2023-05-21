package com.example.Music_Streamning_Service_API.controller;

import com.example.Music_Streamning_Service_API.exception.ResourceNotFoundException;
import com.example.Music_Streamning_Service_API.model.User;
import com.example.Music_Streamning_Service_API.service.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@Valid @RequestBody User user) {
        Optional<User> existingUser = userService.getUserByUsername(user.getUsername());
        if (existingUser.isPresent()) {
            return ResponseEntity.badRequest().build();
        } else {
            User newUser = userService.registerUser(user);
            return ResponseEntity.ok(newUser);
        }
    }


    @PostMapping("/password/reset")
    public ResponseEntity<?> resetPassword(@RequestParam String username) {
        Optional<User> optionalUser = userService.getUserByUsername(username);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();

            // generate and send password reset email
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") @Min(1) Long id) {
        User user = userService.getUserById(id);

        if (user == null) {
            throw new ResourceNotFoundException("User not found");
        }

        return ResponseEntity.ok(user);
    }

    @GetMapping("/")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();

        return ResponseEntity.ok(users);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") @Min(1) Long id, @Valid @RequestBody User user) {
        User existingUser = userService.getUserById(id);

        if (existingUser == null) {
            throw new ResourceNotFoundException("User not found");
        }

        existingUser.setUsername(user.getUsername());
        existingUser.setPassword(user.getPassword());

        User updatedUser = userService.updateUser(existingUser);

        return ResponseEntity.ok(updatedUser);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") @Min(1) Long id) {
        User existingUser = userService.getUserById(id);

        if (existingUser == null) {
            throw new ResourceNotFoundException("User not found");
        }

        userService.deleteUser(existingUser);

        return ResponseEntity.noContent().build();
    }
}