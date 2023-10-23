package mx.ulsa.josiaslpsw.service;

import mx.ulsa.josiaslpsw.model.Usuario;
import mx.ulsa.josiaslpsw.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    IUsuarioRepository usuarioRepo;

    public List<Usuario> getAllUsuario(){
        List<Usuario> usuarioList = new ArrayList<Usuario>();
        usuarioRepo.findAll().forEach(usuario -> usuarioList.add(usuario));
        return usuarioList;
    }
    public Usuario getUsuarioById(Long id) {return usuarioRepo.findById(id).get();}

    public boolean saveOrUpdaateUsuario(Usuario usuario){
        Usuario updateUsuario = usuarioRepo.save(usuario);
        if(usuarioRepo .findById(updateUsuario.getIdUsuario().longValue()) != null){
            return true;
        }
        return false;
    }
    public boolean deleteUsuario(Long id) {
        usuarioRepo.deleteById(id);
        if (usuarioRepo.findById(id) != null) {
            return true;
        }

        return false;
    }

}
