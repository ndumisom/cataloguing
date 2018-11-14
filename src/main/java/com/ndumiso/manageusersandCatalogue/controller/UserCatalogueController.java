package com.ndumiso.manageusersandcatalogue.controller;

import com.ndumiso.manageusersandcatalogue.exception.ResourceNotFoundException;
import com.ndumiso.manageusersandcatalogue.model.User;
import com.ndumiso.manageusersandcatalogue.model.UserCatalogue;
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
@RequestMapping("/api/user")
public class UserCatalogueController {

    @Autowired
    UserCatalogueRepository userCatalogueRepository;


    @GetMapping("/{id}/name")
    public List<UserCatalogue> getAllUserCatalogue() {
        return userCatalogueRepository.findAll();
    }

    @PostMapping("/{id}/name")
    public UserCatalogue createUserCatalogue(@RequestBody @Valid UserCatalogue userCatalogue,@PathVariable(value = "id") Long userCatalogueId) {
        userCatalogue.setUserId(userCatalogueId);
        return userCatalogueRepository.save(userCatalogue);
    }

    @GetMapping("/{id}/name/{id}")
    public UserCatalogue getUserCatalogueById(@PathVariable(value = "id") Long userCatalogueId) {
        return userCatalogueRepository.findById(userCatalogueId).orElseThrow(() -> new ResourceNotFoundException("UserCatalogue", "id", userCatalogueId));
    }

    @PutMapping("/{id}/name/{id}")
    public UserCatalogue updateUserCatalogue(@PathVariable(value = "id") Long userCatalogueId,
                                   @RequestBody @Valid User userDetails) {

        UserCatalogue userCatalogue = userCatalogueRepository.findById(userCatalogueId).orElseThrow(() -> new ResourceNotFoundException("UserCatalogue", "id", userCatalogueId));
        userCatalogue.setName(userCatalogue.getName());

        UserCatalogue updatedUserCatalogue = userCatalogueRepository.save(userCatalogue);
        return updatedUserCatalogue;
    }

    @DeleteMapping("/{id}/name/{id}")
    public ResponseEntity<?> deleteUserCatalogue(@PathVariable(value = "id") Long userCatalogueId) {
        UserCatalogue userCatalogue = userCatalogueRepository.findById(userCatalogueId).orElseThrow(() -> new ResourceNotFoundException("UserCatalogue", "id", userCatalogueId));

        userCatalogueRepository.delete(userCatalogue);

        return ResponseEntity.ok().build();
    }


}
