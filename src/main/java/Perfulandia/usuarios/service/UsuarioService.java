package Perfulandia.usuarios.service;
import java.util.List;

import Perfulandia.usuarios.model.Usuario;
import Perfulandia.usuarios.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

public List<Usuario> finAll(){
   return usuarioRepository.findAll();
}

public Usuario findById( long ID){
  return usuarioRepository.findById(ID).get();
}

public Usuario save(Usuario usuario){
    return usuarioRepository.save(usuario);

}

public void delete (Long id) {
  usuarioRepository.deleteById(id);
}

public List<Usuario> buscarPorEmail(String email) {
    return usuarioRepository.findByEmail(email);
}

public List<Usuario> getUsuariosInactivos() {
    return usuarioRepository.findByActivoFalse();
}


}