package springBoot.transaction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import springBoot.transaction.beans.Purchase;

@SpringBootApplication
public class AppMain {
    public static void main(String[] args) {
        ApplicationContext appContext = SpringApplication.run(AppMain.class);
        Purchase purchase = appContext.getBean(Purchase.class);
        purchase.makePayment();
    }
}
