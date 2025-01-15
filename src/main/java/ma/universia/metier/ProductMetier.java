package ma.universia.metier;


import ma.universia.entities.Product;

import java.math.BigDecimal;
import java.util.List;


public interface ProductMetier {
    Product findByPriceAndName(BigDecimal price, String name);
    Product addProduct(Product product);
    Product getProductById(Long id);
    List<Product> getAllProducts();
    Product updateProduct(Long id, Product product);
    void deleteProduct(Long id);
    Product findByName(String name);
    List<Product> findByPriceBetween(BigDecimal price1, BigDecimal price2);
    List<Product> findByNameContaining(String name);
}
	

