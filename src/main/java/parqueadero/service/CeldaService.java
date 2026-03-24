package parqueadero.service;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import parqueadero.model.Celda;
import parqueadero.model.Usuario;
import parqueadero.repository.CeldaRepository;
import parqueadero.repository.UsuarioRepository;

import java.util.List;

@Service
public class CeldaService {

    @Autowired
    private CeldaRepository cellRepository;

    @Autowired
    private UsuarioRepository userRepository;

    public List<String> getAvailableCells() {
        return cellRepository.findByAvailableTrue()
                .stream()
                .map(Celda::getCode)
                .toList();
    }

    public Celda crear(Celda celda) {
        celda.setAvailable(true);
        return cellRepository.save(celda);
    }

    public Celda assignCell(Long celdaId, Long userId) {
        Celda celda = cellRepository.findById(celdaId)
                .orElseThrow(() -> new RuntimeException("Cell not found"));

        Usuario user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!celda.isAvailable()) {
            throw new RuntimeException("Cell not available");
        }

        celda.setAvailable(false);
        celda.setAssignedUser(user);

        return cellRepository.save(celda);
    }

    public Celda releaseCell(Long celdaId) {
        Celda celda = cellRepository.findById(celdaId)
                .orElseThrow(() -> new RuntimeException("Cell not found"));

        celda.setAvailable(true);
        celda.setAssignedUser(null);

        return cellRepository.save(celda);
    }
}
