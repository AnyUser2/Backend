package parqueadero.controller;

import parqueadero.model.Registro;
import parqueadero.service.ParqueaderoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registros")
@CrossOrigin
public class RegistroController {

    private final ParqueaderoService service;

    public RegistroController(ParqueaderoService service) {
        this.service = service;
    }

    @PostMapping("/entrada")
    public Registro registrarEntrada(
            @RequestParam String placa,
            @RequestParam String nombre,
            @RequestParam String telefono
    ) {
        return service.registrarEntrada(placa, nombre, telefono);
    }

    @PostMapping("/salida/{id}")
    public Registro registrarSalida(@PathVariable Integer id) {
        return service.registrarSalida(id);
    }

    @GetMapping("/historial")
    public List<Registro> historial() {
        return service.consultarHistorial();
    }

    @GetMapping("/activos")
    public List<Registro> activos() {
        return service.consultarVehiculosDentro();
    }

}
