package services;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import models.Category;
import repositories.CategoryRepository;
import repositories.ProductRepository;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private ProductRepository productRepository;
	public CategoryService(CategoryRepository categoryRepository, ProductRepository productRepository) {
		this.categoryRepository = categoryRepository;
		this.productRepository = productRepository;
	}
	public void addCategory(Category category) {
		categoryRepository.save(category);
	}
	public List<Category> getAll() {
		return (List<Category>) categoryRepository.findAll();
	}
	public Object getOne(Long id) {
		return categoryRepository.findById(id);
	}
	public void update(Category category) {
		categoryRepository.save(category);
	}
	public List<Category> getAllExcept(Long productId) {
		List<Category> categories = this.getAll();
		List<Category> productCategories = productRepository.findById(productId).getCategories();
		categories.removeAll(productCategories);
		return categories;
	}
}
