package com.facturacion.main.service.user.impl;

import com.facturacion.main.model.User;
import com.facturacion.main.repository.UserRepository;
import com.facturacion.main.service.user.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    @Override
    public User saveUser(User user) {
        return userRepository.save((user));
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findByIdUser(id);
    }


}
