package part1;

import java.util.ArrayList;

public class Product {

    private String name;
    private Float defaultPrice;
    private ProductCategory productCategory;
    private Integer ID;
    private static int count = 0;
    private static ArrayList<Product> productList = new ArrayList<>();

    public Product() {

    }


    public Product(String name, Float defaultPrice, ProductCategory productCategory) {

        this.ID = ++count;
        this.name = name;
        this.defaultPrice = defaultPrice;
        this.productCategory = productCategory;
        productList.add(this);
    }

    public Product getProduct(int index) {
        Product product = null;
        for (Product p : productList) {
            if(p.getID().equals(index)) {
                product = p;
            }
        }
        return product;
    }

    public ArrayList getAllProducts() {

        return productList;
    }

    public ArrayList getAllProductsBy(ProductCategory productCategory) {
        return productList;
    }

    @Override
    public String toString() {


        return productCategory.getClass().getName() + "," + ID + "," + name + "," + defaultPrice;
    }

    public Integer getID() {
        return ID;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }
}
