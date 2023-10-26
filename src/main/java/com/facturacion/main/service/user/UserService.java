package com.facturacion.main.service.user;

import com.facturacion.main.model.User;

import java.util.Optional;

public interface UserService {
    User saveUser(User user);
    User getUserByEmail(String email);
    User getUserById(Long id);
}
