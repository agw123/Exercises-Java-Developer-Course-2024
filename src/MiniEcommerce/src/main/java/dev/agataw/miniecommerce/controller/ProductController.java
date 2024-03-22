package dev.agataw.miniecommerce.controller;

import com.google.gson.Gson;
import dev.agataw.miniecommerce.controller.utility.HttpResponse;
import dev.agataw.miniecommerce.model.Product;
import dev.agataw.miniecommerce.service.ProductService;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import spark.Spark;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static spark.Spark.*;

@Slf4j
@Log
public class ProductController {
    ProductService productService = new ProductService();

    public void startWebServices() {

        get("/products", (req, res) -> {
            res.type("application/json");
            HttpResponse response = new HttpResponse("200", (new Gson()).toJsonTree(productService.getProducts()));
            return (new Gson()).toJson(response);
        });

        post("/product", (req, res) -> {

            Product p1 = new Product(1, "Cuffie",20, 3.40, "Lorem");
            // Product productFromReq = (Product) (new Gson()).fromJson(req.body(), Product.class);
            // productsList.add(p1);
            productService.addProduct(p1);
            // productsList.add(p2);
            HttpResponse response = new HttpResponse("201", (new Gson()).toJsonTree(p1));
            // HttpResponse response2 = new HttpResponse("201", (new Gson()).toJsonTree(p2));
            return (new Gson()).toJson(response);
        });

        put("/product", (req, res) -> {
            Product product = (new Gson()).fromJson(req.body(), Product.class);
            boolean find = false;
            Iterator i = productService.getProducts().iterator();
            while(i.hasNext()) {
                Product p = (Product) i.next();
                if (p.getId() == product.getId()) {
                    p.setAmount(product.getAmount());
                    find = true;
                }
            }
            if (find) {
                return new HttpResponse("200", (new Gson()).toJsonTree(product));
            } else {
                return new HttpResponse("404", (new Gson()).toJsonTree("Product not found"));
            }
        });

        delete("/product/:productID", (req, res) -> {
            String s = req.params("productID");
            Long paramID = Long.parseLong(s);
            System.out.println(paramID);
            if (!productService.getProducts().isEmpty()){
                Iterator<Product> i = productService.getProducts().iterator();
                while(i.hasNext()) {
                    Product p = i.next();
                    if (p.getId() == paramID) {
                        System.out.println("Delete product");
                        i.remove();
                    }
                }
                return new HttpResponse("201", (new Gson()).toJsonTree("Product deleted"));
            }
            return new HttpResponse("404", (new Gson()).toJsonTree("Product not found"));
        });
    }

}
