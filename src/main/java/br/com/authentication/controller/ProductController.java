package br.com.authentication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.authentication.DTO.ProductDTO;
import br.com.authentication.model.ProductModel;
import br.com.authentication.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@PostMapping("/register")
	public ResponseEntity<ProductModel> createProduct(@RequestBody ProductDTO dto) {
		ProductModel savedProduct = productService.createProduct(dto);
		return ResponseEntity.ok(savedProduct);
	}
	
	@GetMapping
	public ResponseEntity<List<ProductModel>> getAllProducts() {
		return ResponseEntity.ok(productService.getAllProduct());
	}
}
