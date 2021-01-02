package pe.isil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.isil.model.Supplier;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Integer> {
}
