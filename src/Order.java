import java.util.List;

public class Order {
    long id;
    Customer customer;
    List<Product> products;
    OrderStatus status;
    public Order(long id, Customer customer, List<Product> products, OrderStatus status) {
        this.id = id;
        this.customer = customer;
        this.products = products;
        this.status = status;
    }
    @Override
    public String toString() {
        return "ID " + id + " Customer " + customer.name + " Status " + status;
    }
}
