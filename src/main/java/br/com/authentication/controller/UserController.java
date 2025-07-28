package br.com.authentication.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.authentication.DTO.RegisterDTO;
import br.com.authentication.service.RegisterService;

@RestController
@RequestMapping("/user")
public record UserController(RegisterService registerService) {

	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody RegisterDTO dto) {
		return registerService.register(dto);
	}
}