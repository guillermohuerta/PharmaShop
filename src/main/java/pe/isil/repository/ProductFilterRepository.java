package pe.isil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.isil.model.Product;

import java.util.List;

@Repository
public interface ProductFilterRepository extends JpaRepository<Product, Integer> {

    @Query("SELECT p FROM Product p WHERE "
            + " CONCAT(p.name, p.category.name, p.price, p.description)"
            + " LIKE %?1%")
    public List<Product> findAll(String keyword);

}
