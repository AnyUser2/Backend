package parqueadero.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import parqueadero.model.Usuario;
import parqueadero.repository.UsuarioRepository;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository userRepository;

    public Usuario createUser(Usuario user) {
        user.setActive(true);
        return userRepository.save(user);
    }

    public List<Usuario> getAllUsers() {
        return userRepository.findAll();
    }

    public Usuario disableUser(Long id) {
        Usuario user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setActive(false);
        return userRepository.save(user);
    }
}
