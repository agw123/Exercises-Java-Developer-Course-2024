package dev.agataw.miniecommerce.service;

import dev.agataw.miniecommerce.dao.ProductDao;
import dev.agataw.miniecommerce.dao.ProductDaoCollection;
import dev.agataw.miniecommerce.model.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.rmi.NoSuchObjectException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductService {

    ProductDao dao = new ProductDaoCollection();


    public void getProduct(Long id) {

    }

    public Set<Product> getProducts(){
        return dao.getAllProducts();
    }

    public void addProduct(Product p) {
        if (p != null) {
            dao.insert(p);
        }
    }

    public void buyProduct(Product p, int amountToBuy) throws NoSuchObjectException {
        if (p.getAmount() > 0) {
            p.setAmount(p.getAmount() - amountToBuy);
            dao.update(p);
        }
    }

    public void deleteProduct(long id) {
        dao.deleteProduct(id);
    }

}
