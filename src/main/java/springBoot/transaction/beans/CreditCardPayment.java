package springBoot.transaction.beans;

import org.springframework.stereotype.Component;

@Component
//@Primary
public class CreditCardPayment implements Payment {
    @Override
    public String pay(long amount) {
        return "Credit card payment of: "+amount;
    }
}
