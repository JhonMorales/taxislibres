package com.facturacion.main.service.login;

import com.facturacion.main.dto.UserLoginDto;

public interface LoginService {
    UserLoginDto getJwt(String email, String password);
}
