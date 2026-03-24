package parqueadero.service;

import parqueadero.model.Registro;
import parqueadero.model.Vehiculo;
import parqueadero.repository.RegistroRepository;
import parqueadero.repository.VehiculoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ParqueaderoService {

    private final VehiculoRepository vehiculoRepository;
    private final RegistroRepository registroRepository;

    public ParqueaderoService(VehiculoRepository vehiculoRepository, RegistroRepository registroRepository) {
        this.vehiculoRepository = vehiculoRepository;
        this.registroRepository = registroRepository;
    }

    public Vehiculo registrarVehiculo(Vehiculo vehiculo) {
        return vehiculoRepository.save(vehiculo);
    }

    public Registro registrarEntrada(String placa, String nombre, String telefono) {

        Vehiculo vehiculo = vehiculoRepository.findById(placa).orElseThrow();

        Registro registro = new Registro();
        registro.setVehiculo(vehiculo);
        registro.setNombreConductor(nombre);
        registro.setTelefonoConductor(telefono);
        registro.setFechaEntrada(LocalDateTime.now());

        return registroRepository.save(registro);
    }

    public Registro registrarSalida(Integer idRegistro) {

        Registro registro = registroRepository.findById(idRegistro).orElseThrow();
        registro.setFechaSalida(LocalDateTime.now());

        return registroRepository.save(registro);
    }

    public List<Registro> consultarHistorial() {
        return registroRepository.findAll();
    }

    public List<Registro> consultarVehiculosDentro() {
        return registroRepository.findByFechaSalidaIsNull();
    }

    public List<Vehiculo> listarVehiculos() {
        return vehiculoRepository.findAll();
    }

}
