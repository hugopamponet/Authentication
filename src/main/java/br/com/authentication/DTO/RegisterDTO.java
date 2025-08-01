package br.com.authentication.DTO;

import java.time.LocalDate;

import br.com.authentication.enumeration.SexEnum;
import br.com.authentication.enumeration.UsersRole;

public record RegisterDTO(String name, LocalDate dtBirth, SexEnum sex, String email, String cpf, String enterprise,
		UsersRole role, String login, String password) {
}
