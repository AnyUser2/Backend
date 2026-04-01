package parqueadero.controller;

import org.springframework.web.bind.annotation.*;
import parqueadero.model.Vehiculo;
import parqueadero.service.VehiculoService;

import java.util.List;

@RestController
@RequestMapping("/vehiculos")
public class VehiculoController {

    private final VehiculoService service;

    public VehiculoController(VehiculoService service) {
        this.service = service;
    }

    @PostMapping
    public Vehiculo crear(@RequestBody Vehiculo vehiculo) {
        return service.crear(vehiculo);
    }

    @GetMapping
    public List<Vehiculo> listar() {
        return service.listar();
    }
}