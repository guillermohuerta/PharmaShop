package pe.isil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.isil.model.Depot;

@Repository
public interface DepotRepository extends JpaRepository<Depot, Integer> {
}
