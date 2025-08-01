package br.com.authentication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.authentication.DTO.LoginDTO;
import br.com.authentication.DTO.RegisterDTO;
import br.com.authentication.model.UsersModel;
import br.com.authentication.repository.UserRepository;
import br.com.authentication.service.AuthorizationService;

@RestController
@RequestMapping("auth")
public class AuthenticationController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserRepository repository;
	
	@PostMapping("/register")
	public ResponseEntity register(@RequestBody @Validated RegisterDTO dto) {
		if(this.repository.findByLogin(dto.login()) != null) return ResponseEntity.badRequest().build();
		if(this.repository.findByLogin(dto.cpf()) != null) return ResponseEntity.badRequest().build();
		
		String encryptedPassword = new BCryptPasswordEncoder().encode(dto.password());
		UsersModel newUser = new UsersModel(dto.name(), dto.dtBirth(), dto.sex(), dto.email(), dto.cpf(), dto.enterprise(), dto.role(), dto.login(), encryptedPassword);
		
		this.repository.save(newUser);
		
		return ResponseEntity.ok().build();
	}

	@PostMapping("/login")
	public ResponseEntity login(@RequestBody @Validated LoginDTO dto) {
		var usernamePassword = new UsernamePasswordAuthenticationToken(dto.login(), dto.password());
		var authe = this.authenticationManager.authenticate(usernamePassword);
		
		return ResponseEntity.ok().build();
	}
}
