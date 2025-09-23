package ss12_javaCollectionFramework.bai_tap.bai_tap1;

import java.util.*;

public class ProductManager {
    private static final List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product(1, "Dien Thoai 1", 2.0f));
        productList.add(new Product(2, "Dien Thoai 2", 5.0f));
        productList.add(new Product(3, "Dien Thoai 3", 10.0f));
        productList.add(new Product(4, "Dien Thoai 4", 20.0f));
        productList.add(new Product(5, "Dien Thoai 5", 3.0f));
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

    public void editProduct(Product product) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == product.getId()) {
                productList.get(i).updateFrom(product);
            }
        }
    }

    public List<Product> findAllProduct() {
        return new ArrayList<>(productList);
    }

    public List<Product> findByName(String name) {
        List<Product> product = new ArrayList<>();
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getName().equals(name)) {
                product.add(productList.get(i));
            }
        }
        return product;
    }

    public List<Product> sortByPriceAs() {
        List<Product> products = new ArrayList<>(productList);
        Collections.sort(products, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return Double.compare(o1.getPrice(), o2.getPrice());
            }
        });
        return products;
    }

    public List<Product> sortByPriceDes() {
        List<Product> products = new ArrayList<>(productList);
        Collections.sort(products, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return Double.compare(o2.getPrice(), o1.getPrice());
            }
        });
        return products;
    }
    public void deleteById(int id){
        productList.remove(id);
    }
}
