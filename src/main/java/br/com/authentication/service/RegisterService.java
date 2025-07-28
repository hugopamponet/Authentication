package br.com.authentication.service;

/*import java.util.Optional;*/

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/*import br.com.authentication.DTO.LoginDTO;*/
import br.com.authentication.DTO.RegisterDTO;
import br.com.authentication.model.RegisterModel;
import br.com.authentication.repository.RegisterRepository;

public record RegisterService(RegisterRepository registerRepository) {

	public ResponseEntity<String> register(RegisterDTO dto) {
		if (registerRepository.existsByName(dto.getName())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Usuário já existe");
		}
		
		RegisterModel registerUser = new RegisterModel();
		registerUser.setName(dto.getName());
		registerUser.setEmail(dto.getEmail());
		registerUser.setSex(dto.getSex());
		registerUser.setUser(dto.getUser());
		registerUser.setPassword(dto.getPassword());
		
		registerRepository.save(registerUser);
		
		return ResponseEntity.ok("Usuário cadastrado com sucesso");
	}
	/*
	public ResponseEntity<String> login(LoginDTO dto) {
		Optional<RegisterModel> user = registerRepository.findByName(dto.getUser());
		
		if (user.isPresent() && user.get().getPassword().equals(dto.getPassword())) {
			return ResponseEntity.ok("Login realizado com sucesso");
		}
		
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuário ou senha incorretos.");
		
	}*/
}