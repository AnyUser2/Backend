package parqueadero.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import parqueadero.model.Registro;

import java.util.Optional;

public interface RegistroRepository extends JpaRepository<Registro, Long> {

    Optional<Registro> findByVehiculoId(Long vehiculoId);

    boolean existsByCeldaId(Long celdaId);
}