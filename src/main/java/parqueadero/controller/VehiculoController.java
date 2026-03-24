package parqueadero.controller;

import parqueadero.model.Vehiculo;
import parqueadero.service.ParqueaderoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehiculos")
@CrossOrigin
public class VehiculoController {

    private final ParqueaderoService service;

    public VehiculoController(ParqueaderoService service) {
        this.service = service;
    }

    @PostMapping
    public Vehiculo registrarVehiculo(@RequestBody Vehiculo vehiculo) {
        return service.registrarVehiculo(vehiculo);
    }

    @GetMapping
    public List<Vehiculo> listarVehiculos() {
        return service.listarVehiculos();
    }

}
