package ma.universia.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ma.universia.entities.Product;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

    List<Product> findByName(String name);
    List<Product> findByNameContaining(String name);
    List<Product> findByPriceBetween(BigDecimal price, BigDecimal price2);
    List<Product> findByReference(String reference);
    List<Product> findByNameContainingAndPriceBetween(String name, BigDecimal price, BigDecimal price2);

    @Query("select p from Product p where p.price > :pr and p.name = :n")
    List<Product> findByPriceGreaterAndName(@Param("pr") BigDecimal price , @Param("n") String name);



}
