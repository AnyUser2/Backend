package parqueadero.service;

import org.springframework.stereotype.Service;
import parqueadero.model.Vehiculo;
import parqueadero.repository.VehiculoRepository;

import java.util.List;

@Service
public class VehiculoService {

    private final VehiculoRepository repository;

    public VehiculoService(VehiculoRepository repository) {
        this.repository = repository;
    }

    public Vehiculo crear(Vehiculo vehiculo) {
        return repository.save(vehiculo);
    }

    public List<Vehiculo> listar() {
        return repository.findAll();
    }
}