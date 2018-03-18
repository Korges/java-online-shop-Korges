import product.Basket;
import product.FeaturedProductCategory;
import product.Product;
import product.ProductCategory;
import action.AbstractProcess;
import action.CheckoutProcess;
import action.Order;
import action.PaymentProcess;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Application {

    private Order order;
    private UserInterface ui;
    private AbstractProcess abstractProcess;
    private Basket basket = new Basket();
    private Product product = new Product();
    private ProductCategory productCategory = new ProductCategory();

    private List<String> menuOptions= Arrays.asList("Create new product",
            "create new product category or new featured product category",
            "add some products to the basket",
            "see all products in my basket",
            "remove product from basket",
            "get list of all available products",
            "get list of products from specific product category",
            "pay for my order",
            "EXIT");

    private List<Integer> optionsList = Arrays.asList(1 ,2, 3, 4, 5, 6, 7, 8, 0);

    Application() {
        this.ui = new UserInterface(menuOptions, optionsList);
    }

    public void start() {

        int option;

        do {
            ui.displayMenu();
            option = ui.getMenuOption();

            if (option == 1) {
                createNewProduct();
            }
            else if(option == 2) {
                createNewProductCategory();
            }
            else if(option == 3) {
                addProductToBasket();
            }
            else if(option == 4) {
                seeAllProductsInBasket();
            }
            else if(option == 5) {
                removeProductFromBasket();
            }
            else if(option == 6) {
                listAllProduct();
            }
            else if(option == 7) {
                getListOfSpecificCategory();
            }
            else if(option == 8) {
                payForOrder();
            }

        } while (option != 0);
    }



    private void createNewProduct() {
        String name = ui.getString("Type product name : ");
        Float defaultPrice = ui.getFloat("Type product price : ");

        if (productCategory.getProductCategoryList().size() == 0) {
            ui.showMessage("Category List is Empty !");
        } else {
            listAllProductCategory();
            ProductCategory category;
            do {
                int index = ui.getInt("Choose category : ");
                category = productCategory.getProductCategory(index);
            } while (category == null);
            new Product(name, defaultPrice, productCategory);
            ui.showMessage("New Product created !");
        }
    }

    private void listAllProductCategory() {
        ui.showMessage("List of All Product Category");
        for (ProductCategory category : productCategory.getProductCategoryList()) {
            ui.showMessage(category.getID() + " - " + category.getName());
        }
    }

    private void createNewProductCategory() {

        String name = ui.getString("Type new Category name : ");
        boolean isFeaturedCategory = ui.getBoolean(ui.getString("Do you want add expiration Date? [Yes/No]"));
        if (isFeaturedCategory) {
            Date expirationDate = ui.getExpirationDate();
            productCategory.addProductCategory(new FeaturedProductCategory(name, expirationDate));

        } else {
            productCategory.addProductCategory(new ProductCategory(name));
        }
    }

    private void addProductToBasket() {
        if(product.getAllProducts().size() == 0) {
            ui.showMessage("Product List is empty !");
        } else {
            listAllProduct();
            Product productToAdd;
            do {
                int index = ui.getInt("Choose product : ");
                productToAdd = product.getProduct(index);
            } while (productToAdd == null);
            basket.addProduct(productToAdd);
            ui.showMessage("New Product added to Basket !");
        }
    }

    private void listAllProduct() {
        ui.showMessage("List of All Products");
        for (Object product : product.getAllProducts()) {
            ui.showMessage(product.toString());
        }
    }

    private void seeAllProductsInBasket() {
        if(product.getAllProducts().size() == 0) {
            ui.showMessage("Basket is empty !");
        } else {
            listAllProductInBasket();
        }
    }

    private void listAllProductInBasket() {
        ui.showMessage("List of All Products in Basket");
        for (Object product : basket.getProductList()) {
            ui.showMessage(product.toString());
        }
    }

    private void removeProductFromBasket() {
        if(basket.getProductList().size() == 0) {
            ui.showMessage("Basket is empty !");
        } else {
            listAllProductInBasket();
            Product productToRemove;
            do {
                int index = ui.getInt("Choose product : ");
                productToRemove = basket.getProduct(index);
            } while (productToRemove == null);
            basket.removeProduct(productToRemove);
            ui.showMessage("New Product added to Basket !");
        }
    }

    private void listSpecificCategory(ProductCategory category) {
        ui.showMessage("List of All Products of Specific Category");
        for (Object p : product.getAllProducts()) {
            Product pr = (Product) p;
            if(pr.getProductCategory().equals(category)) {

                ui.showMessage(pr.toString());
            }
        }
    }



    private void getListOfSpecificCategory() {
        if(product.getAllProducts().size() == 0) {
            ui.showMessage("Product List is empty !");
        } else {
            listAllProductCategory();

            ProductCategory category;
            do {
                int index = ui.getInt("Choose category : ");
                category = productCategory.getProductCategory(index);
            } while (category == null);
            listSpecificCategory(category);

        }
    }

    private void payForOrder() {

        order = new Order();
        abstractProcess = new CheckoutProcess();
        abstractProcess.process(order);
        abstractProcess = new PaymentProcess();
        abstractProcess.process(order);
    }
}





































































