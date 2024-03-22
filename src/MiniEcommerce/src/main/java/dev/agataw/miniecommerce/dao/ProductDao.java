package dev.agataw.miniecommerce.dao;

import dev.agataw.miniecommerce.model.Product;

public interface ProductDao {
    public void insert(Product p);
    public void update(Product p);
    public void deleteProduct(long id);
    public void getProduct(Long id);
    public void getAllProducts();
}
