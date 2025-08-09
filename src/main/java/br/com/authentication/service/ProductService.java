package br.com.authentication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.authentication.DTO.ProductDTO;
import br.com.authentication.model.ProductModel;
import br.com.authentication.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public ProductModel createProduct(ProductDTO dto) {
		ProductModel product = new ProductModel();
		product.setName(dto.name());
		product.setPrice(dto.price());
		
		return productRepository.save(product);
	}
	
	public List<ProductModel> getAllProduct() {
		return productRepository.findAll();
	}
}