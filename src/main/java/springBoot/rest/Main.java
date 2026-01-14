package springBoot.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@RestController
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class);
    }

    @PostMapping("/orders")
    public Map<String, String> print(@RequestBody Map<String, String> orderMap) {
        String orderId = orderMap.get("orderId");
        String status = orderMap.get("status");

        Set<String> orderSet = new HashSet<>();
        orderSet.add("0001");
        orderSet.add("0002");

        Set<String> statusSet = new HashSet<>();
        statusSet.add("submitted");
        statusSet.add("processing");
        statusSet.add("shipped");
        statusSet.add("delivering");

        if(!orderSet.contains(orderId) || !statusSet.contains(status)) {
            System.out.println("order is invalid");
        } else {
            System.out.println("order status is "+status);
        }
        return orderMap;
    }
}
