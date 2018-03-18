package product;

import java.util.ArrayList;

public class ProductCategory {

    private String name;
    private Integer ID;
    private static int count = 0;
    private static ArrayList<ProductCategory> productCategoryList = new ArrayList<>();

    public ProductCategory() {

    }

    public ProductCategory(String name) {
        this.ID = ++count;
        this.name = name;
    }

    public ArrayList<ProductCategory> getProductCategoryList() {
        return productCategoryList;
    }

    public ProductCategory getProductCategory(int index) {

        ProductCategory productCategory = null;
        for(ProductCategory category : productCategoryList) {
            if (category.getID().equals(index)) {
                productCategory = category;
            }
        }
        return productCategory;

    }

    public void addProductCategory(ProductCategory productCategory) {
        productCategoryList.add(productCategory);
    }

    public String getName() {
        return name;
    }

    public Integer getID() {
        return ID;
    }
}
