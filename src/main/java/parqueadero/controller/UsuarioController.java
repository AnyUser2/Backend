package parqueadero.controller;

import org.springframework.web.bind.annotation.*;
import parqueadero.model.Usuario;
import parqueadero.service.UsuarioService;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping
    public Usuario crear(@RequestBody Usuario usuario) {
        return service.crear(usuario);
    }

    @GetMapping
    public List<Usuario> listar() {
        return service.listar();
    }
}