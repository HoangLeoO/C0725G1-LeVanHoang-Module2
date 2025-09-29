package ss12_javaCollectionFramework.bai_tap.bai_tap1;


public class TestProduct {
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();
        productManager.addProduct(new Product(1,"Hoang",2000));
        System.out.println(productManager.findByName("Hoang"));
    }
}
