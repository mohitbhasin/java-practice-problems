package springBoot.transactoional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {
    @Autowired
    ProductService productService;

    @Autowired
    OrderService orderService;

    @PostMapping("/order")
    @ResponseBody
    public Product placeOrder(@RequestBody Orders orders) {
        System.out.println("placeOrder post mapping: "+orders);
        System.out.println(orders.id+" productId: "+orders.productId+" quantity: "+ orders.quantity);
        return updateProduct(orders);
    }

    private Product updateProduct(Orders orders) {
        return orderService.placeOrder(orders);
    }
}
