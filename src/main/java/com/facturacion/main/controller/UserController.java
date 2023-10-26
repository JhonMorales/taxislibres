package com.facturacion.main.controller;

import com.facturacion.main.model.User;
import com.facturacion.main.service.user.UserService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@Slf4j
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        System.out.println(user.toString());
        User userSaved = userService.saveUser(user);
        return ResponseEntity.created(
                ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(userSaved.getIdUser()).toUri()
        ).build();
    }

    @GetMapping("/find")
    public ResponseEntity<User> getByEmail(@RequestParam("email") String email){
        System.out.println(email);
        User findUser = userService.getUserByEmail(email);
        if (findUser == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(findUser);
    }
}
