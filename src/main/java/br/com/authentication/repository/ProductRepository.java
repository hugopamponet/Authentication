package br.com.authentication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.authentication.model.ProductModel;

public interface ProductRepository extends JpaRepository<ProductModel, String>{

}
