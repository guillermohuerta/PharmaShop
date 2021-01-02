package pe.isil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.isil.model.TypeUser;

@Repository
public interface TypeUserRepository extends JpaRepository<TypeUser, Integer> {
}
