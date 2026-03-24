package parqueadero.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import parqueadero.model.Usuario;
import parqueadero.service.UsuarioService;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService userService;

    @PostMapping
    public Usuario create(@RequestBody Usuario usuario) {
        return userService.createUser(usuario);
    }

    @GetMapping
    public List<Usuario> list() {
        return userService.getAllUsers();
    }

    @PutMapping("/{id}/disable")
    public Usuario disable(@PathVariable Long id) {
        return userService.disableUser(id);
    }
}
