package ss12_javaCollectionFramework.bai_tap.bai_tap1;

import java.io.*;
import java.util.*;

public class ProductManager {
    private static final String FILE_NAME = "src/ss12_javaCollectionFramework/bai_tap/bai_tap1/product.txt";
    private List<Product> productList = new ArrayList<>();


    public ProductManager() {
        loadFromFile();
    }

    private void loadFromFile() {
        productList.clear();
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            return;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = null;
            while ((line = br.readLine()) != null) {
                productList.add(Product.fromText(line));
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    private void saveToFile() {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
                for (Product product : productList) {
                    bw.write(product.toText());
                    bw.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    public void addProduct(Product product) {
        productList.add(product);
        saveToFile();
    }

    public void editProduct(Product product) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == product.getId()) {
                productList.get(i).updateFrom(product);
                break;
            }
        }
        saveToFile();
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

    public void deleteById(int id) {
        productList.remove(id);
        saveToFile();
    }
}
