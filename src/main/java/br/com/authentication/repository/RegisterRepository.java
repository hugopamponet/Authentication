package br.com.authentication.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.authentication.model.RegisterModel;

public interface RegisterRepository extends JpaRepository<RegisterModel, Long>{

	List<RegisterModel> findByNameContainingIgnoreCase(String name);
	
	Optional<RegisterModel> findByName(String name);
	boolean existsByName(String name);
	boolean existsByUser(String user);
}