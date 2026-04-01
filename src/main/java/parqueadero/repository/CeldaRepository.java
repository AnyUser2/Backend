package parqueadero.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import parqueadero.model.Celda;

public interface CeldaRepository extends JpaRepository<Celda, Long> {
}