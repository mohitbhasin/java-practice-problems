package springBoot.transactoional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {
    @Autowired
    OrdersRepository ordersRepository;

    @Autowired
    ProductService productService;

    @Transactional
    public Product placeOrder(Orders order) {
        ordersRepository.save(order);

        Product product;
        try {
            product = productService.getProduct(order.productId);
        } catch (IllegalArgumentException e) {
            throw e;
        }

        if(product.quantity<order.quantity) {
            throw new IllegalArgumentException("Not enough quantity for the product");
        }

        product.quantity-=order.quantity;

        productService.saveProduct(product);

        ordersRepository.save(order);

        return product;
    }
}
