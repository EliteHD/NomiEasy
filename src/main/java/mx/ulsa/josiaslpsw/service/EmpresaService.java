package mx.ulsa.josiaslpsw.service;

import mx.ulsa.josiaslpsw.model.Empresa;
import mx.ulsa.josiaslpsw.repository.IEmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmpresaService {
    @Autowired
    IEmpresaRepository empresaRepo;

    public List<Empresa> getAllEmpresa(){
        List<Empresa> empresaList = new ArrayList<Empresa>();
        empresaRepo.findAll().forEach(empresa -> empresaList.add(empresa));
        return empresaList;
    }
    public Empresa getEmpresaById(Long id) {return empresaRepo.findById(id).get();}

    public boolean saveOrUpdaateEmpresa(Empresa empresa){
        Empresa updateEmpresa = empresaRepo.save(empresa);

        if(empresaRepo .findById(updateEmpresa.getId().longValue()) != null){
            return true;
        }
        return false;
    }
    public boolean deleteEmpresa(Long id) {
        empresaRepo.deleteById(id);
        if (empresaRepo.findById(id) != null) {
            return true;
        }

        return false;
    }
    
}
