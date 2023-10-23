package mx.ulsa.josiaslpsw.service;

import mx.ulsa.josiaslpsw.model.Empleado;
import mx.ulsa.josiaslpsw.repository.IEmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmpleadoService {
    @Autowired
    IEmpleadoRepository empleadoRepo;


    public List<Empleado> getAllEmpleado(){
        List<Empleado> empleadoList = new ArrayList<Empleado>();
        empleadoRepo.findAll().forEach(empleado -> empleadoList.add(empleado));
        return empleadoList;
    }
    public Empleado getEmpleadoById(Long id) {return empleadoRepo.findById(id).get();}

    public boolean saveOrUpdaateEmpleado(Empleado empleado){
        Empleado updateEmpleado = empleadoRepo.save(empleado);

        if(empleadoRepo .findById(updateEmpleado.getId().longValue()) != null){
            return true;
        }
        return false;
    }
    public boolean deleteEmpleado(Long id) {
        empleadoRepo.deleteById(id);
        if (empleadoRepo.findById(id) != null) {
            return true;
        }

        return false;
    }
}
