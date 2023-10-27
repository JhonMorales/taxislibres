package com.facturacion.main.controller;

import com.facturacion.main.dto.UserLoginDto;
import com.facturacion.main.model.User;
import com.facturacion.main.security.JWTAuthtenticationConfig;
import com.facturacion.main.service.login.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

	@Autowired
	private LoginService loginService;

	@PostMapping("login")
	public ResponseEntity<UserLoginDto> login(
			@RequestParam("email") String email,
			@RequestParam("password") String password) {
		UserLoginDto getJwt = loginService.getJwt(email,password);
		if (getJwt.getEmail() == null) return ResponseEntity.notFound().build();
		return ResponseEntity.ok(getJwt);
	}
}
