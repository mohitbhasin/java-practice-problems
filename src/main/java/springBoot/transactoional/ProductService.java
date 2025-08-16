package springBoot.transactoional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository repository;

    public Product getProduct(int id) {
        return repository.findById(id).orElseThrow();
    }

    public boolean containsProduct(int id) {
        Optional<Product> product = repository.findById(id);
        return product.isPresent();
    }

    public void saveProduct(Product product) {
        repository.save(product);
    }

    @Transactional(propagation = Propagation.MANDATORY)
    // Throws an error if a transaction does not exist in the calling method.
    public void updateProductQuantity(Product product, Orders order) {
        if(order.quantity>product.quantity) {
            // Order details will be rolled back if the product doesn't have enough quantity.
            throw new IllegalArgumentException("Not enough quantity for product: "+product.name);
        }
        product.quantity-=order.quantity;
        repository.save(product);
    }
}
