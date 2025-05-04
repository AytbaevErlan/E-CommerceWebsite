package dev.tbvrln.ecommerce.service;

import dev.tbvrln.ecommerce.model.Product;
import dev.tbvrln.ecommerce.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    //get products by id - work on that

    public void addNewProduct(Product product) {

        Optional<Product> productOptional = productRepository.findByName(product.getName()); // findProductByName
        if (productOptional.isPresent()) {
            throw new IllegalStateException("product is taken");
        }
        productRepository.save(product);
    }


    public void deleteProduct(Long productId) {
        productRepository.findById(productId);  // findProductByName
        boolean exists = productRepository.existsById(productId);
        if (!exists) {
            throw new IllegalStateException("Student with id " + productId + " does not exist");
        }

        productRepository.deleteById(productId);

    }

    @Transactional
    public void updateProduct(Long productId, String name, String description) {
        Product product = productRepository.findById(productId).orElseThrow(()
                -> new IllegalStateException("Student with id " + productId + " does not exist"));

        if (name != null &&
                name.length() > 0 &&
                !Objects.equals(product.getName(), name)) {
            product.setName(name);
        }
        if (description != null &&
                description.length() > 0 &&
                !Objects.equals(product.getDescription(), description)) {
            Optional<Product> productOptional = productRepository.findByName(description);  // findProductByName
            if (productOptional.isPresent()) {
                throw new IllegalStateException("product taken");
            }
            product.setDescription(description);
        }
    }
}
