package mx.ulsa.josiaslpsw.controller;

import mx.ulsa.josiaslpsw.model.Empresa;
import mx.ulsa.josiaslpsw.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller

public class EmpresaController {
    @Autowired
    EmpresaService empresaService;


    @PostMapping("/saveEmpresaDh")
    public String saveEmpresa2(@ModelAttribute Empresa empresa, RedirectAttributes redirectAttributes) {
        if(empresaService.saveOrUpdaateEmpresa(empresa)){
            redirectAttributes.addFlashAttribute("message","Registro Exitoso");
            return "redirect:/empresasDh";
        }
        redirectAttributes.addFlashAttribute("message", "Error al registrar Empresa");
        return "redirect:/addEmpresa2";
    }
    @GetMapping("/addEmpresa2")
    public String addEmpresa2(@ModelAttribute("message") String message, Model model) {
        model.addAttribute("empresa", new Empresa());
        model.addAttribute("message", message);

        return "redirect:/empresasDh";
    }


    @GetMapping("/empresasDh")
    public String viewEmpresas(Model model){
        model.addAttribute("empresa", new Empresa());

        model.addAttribute("listaEmpresas", empresaService.getAllEmpresa());
        return "dashboard/empresasDashboard";
    }

    @GetMapping("/eliminarEmpresa/{id}")
    public String eliminarEmpresa(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        empresaService.deleteEmpresa(id.longValue());
        redirectAttributes.addFlashAttribute("message", "Empresa eliminado con éxito");
        return "redirect:/empresasDh";
    }

    @GetMapping("/editarEmpresa/{id}")
    public String editarEmpresa(@PathVariable Integer id, Model model) {
        // Recupera el empresa que deseas editar por su ID
        Empresa empresa = empresaService.getEmpresaById(id.longValue());

        model.addAttribute("empresa", empresa);


        return "Modal/empresaEditar";
    }

    @PostMapping("/editSaveEmpresa")
    public String editSaveEmpresa(Empresa empresa, RedirectAttributes redirectAttributes) {
        if (empresaService.saveOrUpdaateEmpresa(empresa)) {
            redirectAttributes.addFlashAttribute("message", "Empresa actualizado correctamente");
            return "redirect:/empresasDh";
        }

        redirectAttributes.addFlashAttribute("message", "Error al actualizar Empresa");
        return "redirect:/editarEmpresa/" + empresa.getId();
    }
}
