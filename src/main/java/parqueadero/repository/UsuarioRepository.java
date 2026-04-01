package parqueadero.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import parqueadero.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}