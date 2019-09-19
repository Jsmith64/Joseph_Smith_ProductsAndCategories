package repositories;

import org.springframework.data.repository.CrudRepository;

import models.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {

}