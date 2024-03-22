package dev.agataw.miniecommerce.service;

import dev.agataw.miniecommerce.dao.ProductDao;
import dev.agataw.miniecommerce.model.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.rmi.NoSuchObjectException;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductService {

    ProductDao dao;
    List<Product> products = new ArrayList<>();

    public void getProduct(Long id){

    }
    public List<Product> getAllProducts(){
        return products;
    }

    public void addProduct(Product p){
        dao.insert(p);
    }

    public void buyProduct(Product p, int amountToBuy) throws NoSuchObjectException {
        if (p.getAmount() > 0) {
            p.setAmount(p.getAmount() - amountToBuy);
            dao.update(p);
        }
    }

    public void deleteProduct(long id){
        dao.deleteProduct(id);
    }
}
