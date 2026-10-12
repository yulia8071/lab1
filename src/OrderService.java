import java.util.*;

public class OrderService {
    List<Order> orders= new ArrayList<>();

    void addOrder(Order order){
        orders.add(order);
    }
     void removeOrder(long orderId){
         for (int i = 0; i < orders.size(); i++) {
             if (orders.get(i).id == orderId) {
                 orders.remove(i);
                 return;
             }
         }
     }
    public Order findOrderById(long orderId){
        for(Order order:orders){
            if(order.id==orderId ){
                return order;
            }
        }
        return null;
    }
    public List<Order> findOrdersByCustomer(long customerId){
        List<Order> result = new ArrayList<>();
        for(Order order:orders){
            if(order.customer.id==customerId){
                result.add(order);
            }
        }
        return result;
    }
    public List<Order> findOrdersByStatus(OrderStatus status){
        List<Order> result = new ArrayList<>();
        for(Order order:orders){
            if(order.status==status){
                result.add(order);
            }
        }
        return result;
    }
    List<Order> findOrdersContainingProduct(long productId) {
        List<Order> result = new ArrayList<>();
        for (Order order : orders) {
            for (Product product : order.products) {
                if (product.id == productId) {
                    result.add(order);
                }
            }
        }
        return result;
    }
    double calculateOrderTotal(long orderId){
        double total=0;
        Order order= findOrderById(orderId);
        if(order==null){
            return 0;
        }
        for(Product product:order.products){
                total+=product.price;
        }
        return total;
    }

    Set<Customer> findCustomersWithOrders(){
        Set<Customer> customers = new HashSet<>();
        for(Order order:orders){
                    customers.add(order.customer);
                }
        return customers;
    }
    List<Order> sortOrdersByTotalPrice(){
        List<Order> result = new ArrayList<>();
        for(Order order:orders){
            result.add(order);
            }
        for(int i=result.size()-1;i>=0;i--){
            for(int j=result.size()-1;j>i;j--){
                if(calculateOrderTotal(result.get(i).id)>calculateOrderTotal(result.get(j).id)){
                    Order  temp=result.get(i);
                    result.set(i,result.get(j));
                    result.set(j,temp);
                }
            }
        }
        return result;
    }

    Map<OrderStatus, Long> countOrdersByStatus() {
        Map<OrderStatus, Long> result = new HashMap<>();
        for (OrderStatus status : OrderStatus.values()) {
            long count = 0;
            for (Order order : orders) {
                if (order.status == status) {
                    count++;
                }
            }
            result.put(status, count);
        }
        return result;
    }
}
