package parqueadero.repository;

import parqueadero.model.Registro;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RegistroRepository extends JpaRepository<Registro, Integer> {

    List<Registro> findByFechaSalidaIsNull();

}