package springBoot.transactoional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;

@Service
public class AppService {
    @Transactional
    public void placeOrder(int productId, int quantity) {
        String a = "asda";
        Comparator<String> comp;
        Object c;
        List<String> list;

    }
}
