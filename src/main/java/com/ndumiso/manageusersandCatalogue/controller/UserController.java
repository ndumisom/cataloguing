package com.ndumiso.manageusersandcatalogue.controller;

import com.ndumiso.manageusersandcatalogue.exception.ResourceNotFoundException;
import com.ndumiso.manageusersandcatalogue.model.User;
import com.ndumiso.manageusersandcatalogue.model.UserCatalogue;
import com.ndumiso.manageusersandcatalogue.repository.UserRepository;
import com.ndumiso.manageusersandcatalogue.repository.UserCatalogueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Ndumiso on 14/06/18.
 */
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserRepository userRepository;
    UserCatalogueRepository userCatalogueRepository;

    @GetMapping("/user")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping("/user")
    public User createUser(@RequestBody @Valid User user) {
        return userRepository.save(user);
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable(value = "id") Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
    }

    @PutMapping("/user/{id}")
    public User updateUser(@PathVariable(value = "id") Long userId,
                           @RequestBody @Valid User userDetails) {

        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        user.setFirstName(user.getFirstName());
        user.setLastName(user.getLastName());
        user.setUserName(user.getUserName());

        User updatedUser = userRepository.save(user);
        return updatedUser;
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable(value = "id") Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

        userRepository.delete(user);

        return ResponseEntity.ok().build();
    }
}
