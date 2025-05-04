package dev.tbvrln.ecommerce.repository;

import dev.tbvrln.ecommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

    //@Query("SELECT p FROM Product p WHERE p.id= ?1")
    Optional<Product> findByName(String name);
}