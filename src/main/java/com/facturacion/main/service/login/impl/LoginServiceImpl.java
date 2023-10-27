package com.facturacion.main.service.login.impl;

import com.facturacion.main.dto.UserLoginDto;
import com.facturacion.main.model.User;
import com.facturacion.main.repository.UserRepository;
import com.facturacion.main.security.JWTAuthtenticationConfig;
import com.facturacion.main.service.login.LoginService;
import com.facturacion.main.service.user.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class LoginServiceImpl implements LoginService {

    private UserRepository userRepository;

    @Autowired
    JWTAuthtenticationConfig jwtAuthtenticationConfig;
    @Override
    public UserLoginDto getJwt(String email, String password) {
        if (!validateEmailInUser(email)) return new UserLoginDto();
        String token = jwtAuthtenticationConfig.getJWTToken(email);
        return new UserLoginDto(email, password,token);
    }

    private Boolean validateEmailInUser(String email){
        User findUser = userRepository.findByEmail(email);
        return (findUser != null);
    }
}
