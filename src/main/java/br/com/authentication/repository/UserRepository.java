package br.com.authentication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.authentication.model.UsersModel;

public interface UserRepository extends JpaRepository<UsersModel, String>{

	UserDetails findByLogin(String login);
}
