package dev.agataw.miniecommerce.dao;

import dev.agataw.miniecommerce.model.Product;

import java.util.Set;

public interface ProductDao {
    public Product insert(Product p);
    public void update(Product p);
    public void deleteProduct(long id);
    public void getProduct(Long id);
    public Set<Product> getAllProducts();
}
