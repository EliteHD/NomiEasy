package mx.ulsa.josiaslpsw.service;

import mx.ulsa.josiaslpsw.model.Rol;
import mx.ulsa.josiaslpsw.repository.IRolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service

public class RolService {

    @Autowired
    IRolRepository rolRepo;


    public List<Rol> getAllRol(){
        List<Rol> rolList = new ArrayList<Rol>();
        rolRepo.findAll().forEach(rol -> rolList.add(rol));
        return rolList;
    }
    public Rol getRolById(Long id) {return rolRepo.findById(id).get();}

    public boolean saveOrUpdateRol(Rol rol){
        Rol updateRol = rolRepo.save(rol);

        if(rolRepo .findById(updateRol.getIdRol().longValue()) != null){
            return true;
        }
        return false;
    }
    public boolean deleteRol(Long id) {
        rolRepo.deleteById(id);
        if (rolRepo.findById(id) != null) {
            return true;
        }

        return false;
    }

    public Optional<Rol> findByNombre(String nombre) {
        return rolRepo.findByNombre(nombre);
    }


}
