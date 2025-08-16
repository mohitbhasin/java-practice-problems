package springBoot.transactoional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {
    @Autowired
    OrdersRepository ordersRepository;

    @Autowired
    ProductService productService;

    @Autowired
    LogEventService logEventService;

    @Transactional
    public Product placeOrder(Orders order) {
        // save order details to the db.
        // Without @Transactional, order saved to db will not be rolled back,
        // if the product id doesn't exist and throws an error.
        ordersRepository.save(order);

        Product product=productService.getProduct(order.productId);

        // logSaveEvent will not be rolled back if updateProductQuantity fails.
        // logSaveEvent() has transactional.not_supported.
        logEventService.logSaveEvent(order, product);

        // Save order is rolled back if there is not enough quantity.
        productService.updateProductQuantity(product, order);

        return product;
    }
}
