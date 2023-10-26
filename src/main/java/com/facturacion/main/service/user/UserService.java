package com.facturacion.main.service.user;

import com.facturacion.main.model.User;

public interface UserService {
    User saveUser(User user);
    User getUserByEmail(String email);
}
