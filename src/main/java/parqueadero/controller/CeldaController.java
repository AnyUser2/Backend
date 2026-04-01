package parqueadero.controller;

import org.springframework.web.bind.annotation.*;
import parqueadero.model.Celda;
import parqueadero.service.CeldaService;

import java.util.List;

@RestController
@RequestMapping("/celdas")
public class CeldaController {

    private final CeldaService service;

    public CeldaController(CeldaService service) {
        this.service = service;
    }

    @PostMapping
    public Celda crear(@RequestBody Celda celda) {
        return service.crear(celda);
    }

    @GetMapping
    public List<Celda> listar() {
        return service.listar();
    }
}