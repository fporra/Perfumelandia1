package Perfulandia.usuarios.controller;

import Perfulandia.usuarios.model.Usuario;
import Perfulandia.usuarios.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<Usuario>> listar() {
        List<Usuario> usuarios = usuarioService.finAll(); 
        if (usuarios.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> obtenerPorId(@PathVariable Long id) {
        Usuario usuario = usuarioService.findById(id); 
        return usuario != null 
                ? ResponseEntity.ok(usuario) 
                : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Usuario> guardar(@RequestBody Usuario usuario) {
        Usuario nuevo = usuarioService.save(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        usuarioService.delete(id); 
        return ResponseEntity.noContent().build();
    }
}

