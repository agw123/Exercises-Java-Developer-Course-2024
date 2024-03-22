package dev.agataw.miniecommerce.dao;

import dev.agataw.miniecommerce.model.Product;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProductDaoCollection implements ProductDao{

    Product product = new Product();
    private Set<Product> products;
    private int id;

    public ProductDaoCollection() {
        this.products = new HashSet<>();
    }

    public Product insert(Product p){
        id++;
        this.products.add(p);
        p.setId(id);
        return p;
    }


    public void update(Product p){

    }
    public void deleteProduct(long id){

    }
    public void getProduct(Long id){

    }
    public Set<Product> getAllProducts(){
        return products;
    }
}
