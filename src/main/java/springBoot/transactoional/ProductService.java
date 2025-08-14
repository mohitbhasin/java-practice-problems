package springBoot.transactoional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository repository;

    public Product getProduct(int id) {
        Optional<Product> product = repository.findById(id);
        if(product.isPresent()) {
            return product.get();
        } else {
            throw new IllegalArgumentException("Product not found. Product id:"+id);
        }
    }

    public boolean containsProduct(int id) {
        Optional<Product> product = repository.findById(id);
        return product.isPresent();
    }

    public Product saveProduct(Product product) {
         return repository.save(product);
    }
}
