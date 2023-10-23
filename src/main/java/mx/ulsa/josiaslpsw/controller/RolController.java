package mx.ulsa.josiaslpsw.controller;

import mx.ulsa.josiaslpsw.model.Rol;
import mx.ulsa.josiaslpsw.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller

public class RolController {
    @Autowired
    RolService rolService;

    @PostMapping("/saveRolDh")
    public String saveRol2(@ModelAttribute Rol rol, RedirectAttributes redirectAttributes) {
        if(rolService.saveOrUpdateRol(rol)){
            redirectAttributes.addFlashAttribute("message","Registro Exitoso");
            return "redirect:/rolsDh";
        }
        redirectAttributes.addFlashAttribute("message", "Error al registrar Rol");
        return "redirect:/addRol2";
    }
    @GetMapping("/addRol2")
    public String addRol2(@ModelAttribute("message") String message, Model model) {
        model.addAttribute("rol", new Rol());
        model.addAttribute("message", message);

        return "redirect:/rolsDh";
    }


    @GetMapping("/rolsDh")
    public String viewRols(Model model){
        model.addAttribute("rol", new Rol());
       
        model.addAttribute("listaRols", rolService.getAllRol());
        return "dashboard/rolesDashboard";
    }

    @GetMapping("/eliminarRol/{id}")
    public String eliminarRol(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        rolService.deleteRol(id.longValue());
        redirectAttributes.addFlashAttribute("message", "Rol eliminado con éxito");
        return "redirect:/rolsDh";
    }

    @GetMapping("/editarRol/{id}")
    public String editarRol(@PathVariable Integer id, Model model) {
        // Recupera el rol que deseas editar por su ID
        Rol rol = rolService.getRolById(id.longValue());

        model.addAttribute("rol", rol);
        

        return "Modal/rolEditar";
    }

    @PostMapping("/editSaveRol")
    public String editSaveRol(Rol rol, RedirectAttributes redirectAttributes) {
        if (rolService.saveOrUpdateRol(rol)) {
            redirectAttributes.addFlashAttribute("message", "Rol actualizado correctamente");
            return "redirect:/rolsDh";
        }

        redirectAttributes.addFlashAttribute("message", "Error al actualizar Rol");
        return "redirect:/editarRol/" + rol.getIdRol();
    }
    
}
