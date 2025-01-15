package ma.universia.controllers;

import ma.universia.entities.Product;
import ma.universia.metier.ProductMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductMetier productMetier;

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return productMetier.addProduct(product);
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id) {
        return productMetier.getProductById(id);
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productMetier.getAllProducts();
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
        return productMetier.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productMetier.deleteProduct(id);
    }

    @GetMapping("/search")
    public Product getByPriceGreaterAndName(
            @RequestParam BigDecimal price,
            @RequestParam String name) {

        return productMetier.findByPriceAndName(price, name);
    }

    @GetMapping("/name")
    public Product getProductByName(@RequestParam String name) {
        return productMetier.findByName(name);
    }

    @GetMapping("/pricebetween")
    public List<Product> getProductByPriceInBetween(@RequestParam BigDecimal price1, @RequestParam BigDecimal price2) {
        return productMetier.findByPriceBetween(price1, price2);
    }

    @GetMapping("/namecontain")
    public List<Product> getProductByNameContaining(@RequestParam String name) {
        return productMetier.findByNameContaining(name);
    }

}