package pe.isil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.isil.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
