package springBoot.transactoional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {
    @Autowired
    ProductService productService;

    @Autowired
    OrderService orderService;

    @PostMapping("/order")
    public Product placeOrder(@RequestBody Orders orders) {
        System.out.println("ProductId: "+orders.productId+" quantity: "+ orders.quantity);
        return updateProduct(orders);
    }

    private Product updateProduct(Orders orders) {
        return orderService.placeOrder(orders);
    }
}
