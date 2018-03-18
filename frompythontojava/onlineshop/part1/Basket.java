package part1;

import java.util.ArrayList;

public class Basket {

    private Iterator iterator;
    private ArrayList<Product> productList = new ArrayList<>();

    public Iterator getIterator() {
        return iterator;
    }

    public void addProduct(Product product) {

        productList.add(product);
    }

    public boolean removeProduct(Product product) {

        productList.remove(product);
        return true;
    }

    public Product getProduct(int index) {
        Product product = null;
        for (Product p : productList) {
            if (p.getID().equals(index)) {
                product = p;
            }
        }
        return product;
    }

    public ArrayList getProductList() {
        return productList;
    }


    public class ProductIterator implements Iterator {

        private int index;

        @Override
        public boolean hasNext() {
            return index < productList.size();

        }

        @Override
        public Object next() {
            if(this.hasNext()){
                return productList.get(index++);
            }
            return null;
        }
    }

}
