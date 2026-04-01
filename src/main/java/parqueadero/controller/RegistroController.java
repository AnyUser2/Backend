package parqueadero.controller;

import org.springframework.web.bind.annotation.*;
import parqueadero.model.Registro;
import parqueadero.service.ParqueaderoService;

@RestController
@RequestMapping("/registros")
public class RegistroController {

    private final ParqueaderoService service;

    public RegistroController(ParqueaderoService service) {
        this.service = service;
    }

    @PostMapping
    public Registro crear(@RequestBody RegistroRequest request) {
        return service.crearRegistro(
                request.getUsuarioId(),
                request.getVehiculoId(),
                request.getCeldaId()
        );
    }
}