package ss12_javaCollectionFramework.bai_tap.bai_tap1;


public class TestProduct {
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();
        for (Product p : productManager.findAllProduct()) {
            System.out.println(p.toString());
        }
        for (Product p : productManager.sortByPriceDes()){
            System.out.println(p.toString());
        }
        for (Product p : productManager.sortByPriceAs()){
            System.out.println(p.toString());
        }
    }
}
