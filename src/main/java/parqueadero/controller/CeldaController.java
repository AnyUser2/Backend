package parqueadero.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import parqueadero.model.Celda;
import parqueadero.service.CeldaService;

import java.util.List;

@RestController
@RequestMapping("/celda")
public class CeldaController {

    @Autowired
    private CeldaService cellService;

    @GetMapping("/disponible")
    public List<String> available() {
        return cellService.getAvailableCells();
    }

    @PutMapping("/{celdaId}/release")
    public Celda release(@PathVariable Long celdaId) {
        return cellService.releaseCell(celdaId);
    }

    @PostMapping
    public Celda crearCelda(@RequestBody Celda celda) {
        return cellService.crear(celda);
    }

}