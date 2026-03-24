package parqueadero.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import parqueadero.model.Celda;

import java.util.List;

public interface CeldaRepository extends JpaRepository<Celda, Long> {
    List<Celda> findByAvailableTrue();
}
