package org.example;

import java.util.ArrayList;
import java.util.List;

public class ProductService {

    List<Product> products = new ArrayList<>();

    public void addProduct(Product p) {

        products.add(p);

    }

    public List<Product> getAllProducts() {

        return products;
    }

    public Product getProduct(String name) {

        for(Product p : products){
            if(p.getName()==name){
                return p;
            }
        }
        return null;
    }

    public List<Product> getProductLocation(String location) {
        List<Product> productLocation = new ArrayList<>();

        for(Product p : products){
            if(p.getPlace()==location){
                productLocation.add(p);
            }
        }
        return productLocation;
    }

    public List<Product> getProductWarranty(int warranty) {
        List<Product> productWarranty = new ArrayList<>();

        for(Product p : products){
            if (p.getWarranty()>warranty){
                productWarranty.add(p);
            }
        }
        return productWarranty;
    }

    public List<Product> getProductText(String text) {
        List<Product> productText = new ArrayList<>();

        String str = text.toLowerCase();

        for(Product p : products){
            String name = p.getName().toLowerCase();
            String type = p.getType().toLowerCase();
            String place = p.getPlace().toLowerCase();

            if(name.contains(str) || type.contains(str) || place.contains(str)){
                productText.add(p);
            }
        }
        return productText;

    }

    //used for delegation of work, to keep logical code out of the main class
}
