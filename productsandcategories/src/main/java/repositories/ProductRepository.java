package repositories;

import org.springframework.data.repository.CrudRepository;

import models.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

}
