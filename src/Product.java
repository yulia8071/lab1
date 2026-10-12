public class Product {
    long id;
    String name;
    ProductCategory category;
    double price;
 public Product(long id, String name, ProductCategory category, double price) {
     this.id = id;
     this.name = name;
     this.category = category;
     this.price = price;
 }
}
