package parqueadero.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import parqueadero.model.Vehiculo;

public interface VehiculoRepository extends JpaRepository<Vehiculo, String> {
}