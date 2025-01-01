package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductService {

    List<Product> products = new ArrayList<>();
    ProductDB db = new ProductDB();

    public void addProduct(Product p) {

        products.add(p);

        db.save(p);

    }

    public List<Product> getAllProducts() {

        //return products;
        return db.getAll();
    }

    public Product getProduct(String name) {
        //converting the original method to a stream

        return products.stream()
                .filter(p -> p.getName().equals(name))
                .findFirst()
                .orElse(null);

//        for(Product p : products){
//            if(p.getName()==name){
//                return p;
//            }
//        }
//        return null;
    }

    public List<Product> getProductLocation(String location) {
        //converting the original method to a stream
        return products.stream()
                .filter(p -> p.getPlace().equals(location))
                .collect(Collectors.toList());


//        List<Product> productLocation = new ArrayList<>();
//
//        for(Product p : products){
//            if(p.getPlace()==location){
//                productLocation.add(p);
//            }
//        }
//        return productLocation;
    }

    public List<Product> getProductWarranty(int warranty) {
        //converting the original method to a stream
        return products.stream()
                .filter(p -> p.getWarranty()>warranty)
                .collect(Collectors.toList());

//        List<Product> productWarranty = new ArrayList<>();
//
//        for(Product p : products){
//            if (p.getWarranty()>warranty){
//                productWarranty.add(p);
//            }
//        }
//        return productWarranty;
    }

    public List<Product> getProductText(String text) {
        //converting the original method to a stream

        String str = text.toLowerCase();

        return products.stream()
                .filter(p -> p.getName().toLowerCase().contains(str) ||
                        p.getType().toLowerCase().contains(str) ||
                        p.getPlace().toLowerCase().contains(str))
                .collect(Collectors.toList());

//        List<Product> productText = new ArrayList<>();
//
//        String str = text.toLowerCase();
//
//        for(Product p : products){
//            String name = p.getName().toLowerCase();
//            String type = p.getType().toLowerCase();
//            String place = p.getPlace().toLowerCase();
//
//            if(name.contains(str) || type.contains(str) || place.contains(str)){
//                productText.add(p);
//            }
//        }
//        return productText;

    }

    //used for delegation of work, to keep logical code out of the main class
}
