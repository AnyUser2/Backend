package parqueadero.service;

import org.springframework.stereotype.Service;
import parqueadero.model.*;
import parqueadero.repository.*;

import java.time.LocalDateTime;

@Service
public class ParqueaderoService {

    private final UsuarioRepository usuarioRepository;
    private final VehiculoRepository vehiculoRepository;
    private final CeldaRepository celdaRepository;
    private final RegistroRepository registroRepository;

    public ParqueaderoService(
            UsuarioRepository usuarioRepository,
            VehiculoRepository vehiculoRepository,
            CeldaRepository celdaRepository,
            RegistroRepository registroRepository
    ) {
        this.usuarioRepository = usuarioRepository;
        this.vehiculoRepository = vehiculoRepository;
        this.celdaRepository = celdaRepository;
        this.registroRepository = registroRepository;
    }

    public Registro crearRegistro(Long usuarioId, Long vehiculoId, Long celdaId) {

        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuario no existe"));

        Vehiculo vehiculo = vehiculoRepository.findById(vehiculoId)
                .orElseThrow(() -> new RuntimeException("Vehiculo no existe"));

        Celda celda = celdaRepository.findById(celdaId)
                .orElseThrow(() -> new RuntimeException("Celda no existe"));

        if (!celda.isDisponible()) {
            throw new RuntimeException("Celda ocupada");
        }

        if (registroRepository.findByVehiculoId(vehiculoId).isPresent()) {
            throw new RuntimeException("Vehiculo ya registrado");
        }

        Registro registro = new Registro();
        registro.setUsuario(usuario);
        registro.setVehiculo(vehiculo);
        registro.setCelda(celda);
        registro.setFecha(LocalDateTime.now());

        celda.setDisponible(false);
        celdaRepository.save(celda);

        return registroRepository.save(registro);
    }
}