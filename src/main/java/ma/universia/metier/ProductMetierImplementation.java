package ma.universia.metier;

import ma.universia.dao.ProductRepository;
import ma.universia.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ProductMetierImplementation implements ProductMetier {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product findByPriceAndName(BigDecimal price, String name){
        List<Product> products = productRepository.findByPriceGreaterAndName(price, name);
        return products.isEmpty() ? null : products.get(0);
    }

    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product getProductById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        return product.orElse(null);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }


    @Override
    public Product updateProduct(Long id, Product product) {
        if (productRepository.existsById(id)) {
            product.setId(id);
            return productRepository.save(product);
        }
        return null;
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product findByName(String name) {
        List<Product> products = productRepository.findByName(name);
        return products.isEmpty() ? null : products.get(0);
    }

    @Override
    public List<Product> findByPriceBetween(BigDecimal price1, BigDecimal price2) {
        return productRepository.findByPriceBetween(price1, price2);
    }


    @Override
    public List<Product> findByNameContaining(String name) {
        return productRepository.findByNameContaining(name);
    }
}