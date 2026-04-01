package parqueadero.service;

import org.springframework.stereotype.Service;
import parqueadero.model.Celda;
import parqueadero.repository.CeldaRepository;

import java.util.List;

@Service
public class CeldaService {

    private final CeldaRepository repository;

    public CeldaService(CeldaRepository repository) {
        this.repository = repository;
    }

    public Celda crear(Celda celda) {
        return repository.save(celda);
    }

    public List<Celda> listar() {
        return repository.findAll();
    }
}