package bai_tap_them.product;

import bai_tap_them.student.Student;

public class ProductManager {
    private static final Product[] products = new Product[100];

    static {
        products[0] = new Product(1, "May Tinh1", 30000);
        products[1] = new Product(2, "May Tinh2", 30000);
        products[2] = new Product(3, "May Tinh3", 30000);
        products[3] = new Product(4, "May Tinh4", 30000);
    }

    public Product[] getListProduct() {
        return products;
    }

    public void add(String name, double price) {
        for (int i = 0; i < products.length; i++) {
            if (products[i] == null) {
                int id = i + 1;
                for (Product product : products) {
                    if (product != null) {
                        if (product.getId() == id) {
                            id++;
                        }
                    }
                }
                products[i] = new Product(id, name, price);
                break;
            }
        }
    }
}
