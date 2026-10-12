import java.util.*;
public class main {
    public static void printOrder(List<Order> orders) {
        for (Order order : orders) {
            System.out.println("№ " + order.id + " Customer " + order.customer.name + " Status " + order.status);
        }

    }
    public static void main(String[] args){
        OrderService orderService = new OrderService();
        Customer c1 = new Customer(1, "Юлія", "yulia@gmail.com");
        Customer c2 = new Customer(2, "Марія", "maria@gmail.com");
        Customer c3 = new Customer(3, "Олег", "oleh@gmail.com");

        Product p1 = new Product(1, "Какао-боби", ProductCategory.OTHER, 30000);
        Product p2 = new Product(2, "Телефон", ProductCategory.ELECTRONICS, 20000);
        Product p3 = new Product(3, "Гарі Потер", ProductCategory.BOOKS, 500);
        Product p4 = new Product(4, "Кепка", ProductCategory.CLOTHING, 800);
        Product p5 = new Product(5, "Килим", ProductCategory.HOME, 1200);

        Order o1 = new Order(1, c1 , Arrays.asList(p1, p2), OrderStatus.NEW);
        Order o2 = new Order(2, c2 , Arrays.asList(p2, p3), OrderStatus.DELIVERED);
        Order o3 = new Order(3, c3 , Arrays.asList(p3, p4), OrderStatus.PROCESSING);
        Order o4 = new Order(4,c2  , Arrays.asList(p4, p5), OrderStatus.CANCELLED);
        Order o5 = new Order(5,c3  , Arrays.asList(p5, p4), OrderStatus.SHIPPED);

        orderService.addOrder(o1);
        orderService.addOrder(o2);
        orderService.addOrder(o3);
        orderService.addOrder(o4);
        orderService.addOrder(o5);

        System.out.println("1.Усі замовлення:");
        printOrder(orderService.orders);
        System.out.println("2.Видалити замовлення №3");
        orderService.removeOrder(3);
        printOrder(orderService.orders);
        System.out.println("3.Знайти замовлення за Id(2");
        System.out.println(orderService.findOrderById(2));
        System.out.println("4.Знайти замовлення за CustomerId(2)");
        System.out.println(orderService.findOrdersByCustomer(2));
        System.out.println("5.Знайти замовлення за Status(SHIPPED)");
        System.out.println(orderService.findOrdersByStatus(OrderStatus.SHIPPED));
        System.out.println("6.Знайти замовлення, яке містить ProductId(3)");
        System.out.println(orderService.findOrdersContainingProduct(3));
        System.out.println("7.Прорахувати загальну вартість замовлення за Id(1)");
        System.out.println(orderService.calculateOrderTotal(1));
        System.out.println("8.Покупці, які мають замовлення");
        for (Customer customer : orderService.findCustomersWithOrders()) {
            System.out.println(customer.name);
        }
        System.out.println("9.Сортування замовлень за ціною");
        List<Order> sorted = orderService.sortOrdersByTotalPrice();
        for (Order order : sorted) {
            System.out.println("Замовлення №" + order.id + " Сума: " + orderService.calculateOrderTotal(order.id) + " грн");
        }
        System.out.println("10. Кількість замовлень за статусами:");
        Map<OrderStatus, Long> counts = orderService.countOrdersByStatus();
        for (OrderStatus status : OrderStatus.values()) {
            System.out.println(status + ": " + counts.get(status));
        }
    }
}

