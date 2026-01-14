package springBoot.transaction.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

// Dynamic bean selection - When there are multiple beans of same type, it will throw an error.
// Spring will ask to either
// - set one as @Primary,
// - update consumer to accept multiple
// - use @Qualifier to identify the bean to use.

// Here Payment interface is autowired and
// there are two beans of Payment type - BankPayment and CreditCardPayment

// To resolve it, one of the following can be done:
// - Mark one of them as @Primary
// - Use the variable name to match the bean name
//
@Component
public class Purchase {
    // if @Primary is set, dependency can be called using interface name.
    // @Autowired
    // Payment payment;

    // Using bean name as variable name, if @Primary not set
    @Autowired
    Payment bankPayment;

    @Autowired
    Payment creditCardPayment;

    // @Qualifier will take the name of bean as the @Component name(first letter lower case)
    // custom bean name can be set on the @Component using @Qualifier("name") or @Component("name").
    @Autowired
    @Qualifier("bankPayment")
    Payment anotherBankPayment;

    public void makePayment() {
        System.out.println("bankPayment bean selection by variable name - "+bankPayment.pay(5000));
        System.out.println("CreditCardPayment set as @Primary - "+creditCardPayment.pay(1000));
        System.out.println("Using @Qualifier to select BankPayment - "+anotherBankPayment.pay(3000));
    }
}
