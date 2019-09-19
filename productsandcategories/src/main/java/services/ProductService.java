package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import models.Product;
import repositories.CategoryRepository;
import repositories.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
		this.productRepository = productRepository;
		this.categoryRepository = categoryRepository;
	}
	public void addProduct(Product product) {
		productRepository.save(product);
	}
	public List<Product> getAll(){
		return (List<Product>) productRepository.findAll();
	}
	public Object getOne(Long id) {
		return productRepository.findById(id);
	}
	public void update(Product product) {
		productRepository.save(product);
	}
	public List<Product> getAllExcept(Long categoryId) {
		List<Product> products = this.getAll();
		List<Product> categoryProducts = categoryRepository.findById(categoryId).getProducts();
		products.removeAll(categoryProducts);
		return products;
	}
}
