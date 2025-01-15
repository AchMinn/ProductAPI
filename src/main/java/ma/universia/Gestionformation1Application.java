package ma.universia;

import java.math.BigDecimal;
import ma.universia.entities.Product;
import ma.universia.metier.ProductMetierImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Gestionformation1Application implements CommandLineRunner {

    @Autowired
    private ProductMetierImplementation promo;

    public static void main(String[] args) {
        SpringApplication.run(Gestionformation1Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //	Added product 1 and 2
        Product product1 = new Product();
        product1.setName("Product 1");
        product1.setReference("P1");
        product1.setDescription("Description for Product 1");
        product1.setPrice(new BigDecimal("29.99"));

        Product product2 = new Product();
        product2.setName("Product 2");
        product2.setReference("P2");
        product2.setDescription("Description for Product 2");
        product2.setPrice(new BigDecimal("49.99"));

        promo.addProduct(product1);
        promo.addProduct(product2);
    }
}
