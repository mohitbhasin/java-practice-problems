package springBoot.transaction.beans;

import org.springframework.stereotype.Component;

@Component
public class BankPayment implements Payment{
    @Override
    public String pay(long amount) {
        return "Bank transfer payment of: "+amount;
    }
}
