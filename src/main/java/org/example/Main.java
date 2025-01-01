package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        ProductService service = new ProductService();
//        service.addProduct(new Product("Asus Vivobook","Laptop","Desk",2022));
//        service.addProduct(new Product("Hdmi cable","Cable","Drawer",2020));
//        service.addProduct(new Product("Java Black Book","Cable","Shelf",2025));
//        service.addProduct(new Product("Mac Studio","Computer","Table",2028));
//        service.addProduct(new Product("Logitech Mouse","Mouse","Desk",2028));

        List<Product> products = service.getAllProducts();
        for(Product p : products){
            System.out.println(p);
        }

        //find/return product based on name
        System.out.println("-------------------------------------");
        Product p = service.getProduct("Hdmi cable");
        System.out.println(p);

        //finding/returning all products at a certain location
        System.out.println("-------------------------------------");
        List<Product> locationProducts = service.getProductLocation("Desk");
        for(Product pL : locationProducts){
            System.out.println(pL);
        }

        //finding/returning all products w/ an expired warranty
        System.out.println("-------------------------------------");
        List<Product> warrantyProducts = service.getProductWarranty(2024);
        for(Product pW : warrantyProducts){
            System.out.println(pW);
        }


        //finding/returning all products w/ particular text
        System.out.println("-------------------------------------");
        List<Product> prods = service.getProductText("Black");
        for(Product pT : prods){
            System.out.println(pT);
        }




    }




}