package com.facturacion.main.controller;

import com.facturacion.main.exceptions.BadRequest;
import com.facturacion.main.model.Bill;
import com.facturacion.main.model.User;
import com.facturacion.main.service.bill.BillService;
import com.facturacion.main.service.user.UserService;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Set;

@RestController
@Slf4j
@RequestMapping("api/user")
@Validated
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private BillService billService;

    @PostMapping
    public ResponseEntity<User> createUser(@Valid @RequestBody User user, BindingResult bindingResult) {
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
        if (findUser == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(findUser);
    }

    @GetMapping("{id}")
    public ResponseEntity<User> getById(@PathVariable("id") Long id){
        System.out.println(id);
        User findUser = userService.getUserById(id);
        if (findUser == null) return ResponseEntity.notFound().build();
        Set<Bill> billsByUser =billService.getByIdUser(findUser.getIdUser());
        System.out.println(billsByUser.toString());
        findUser.setBills(billsByUser);
        return ResponseEntity.ok(findUser);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ResponseEntity<BadRequest> handleConstraintViolationException(ConstraintViolationException e) {
        return ResponseEntity.status(400).body(
                BadRequest.builder().error(e.getMessage())
                        .code(400).build()
                );
    }
}
