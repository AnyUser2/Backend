package parqueadero.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import parqueadero.model.Usuario;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);
}
