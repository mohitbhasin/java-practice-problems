package springBoot.transactoional;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Orders {
    // If the next id is generated and assigned
    // and later the transaction rollback,
    // the id will not be used for the next order.
    // This is a normal behavior.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    int productId;
    int quantity;

    // getter and setters are required for repository to set values correctly.
    // Without them, all the class variable take default values(0 for int).
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
