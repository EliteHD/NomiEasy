package mx.ulsa.josiaslpsw.controller;

import mx.ulsa.josiaslpsw.model.Empleado;
import mx.ulsa.josiaslpsw.service.*;
import mx.ulsa.josiaslpsw.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller

public class EmpleadoController {
    @Autowired
    UsuarioService usuarioService;
    @Autowired
    EmpleadoService empleadoService;
    @Autowired
    EmpresaService empresaService;

    

    @PostMapping("/saveEmpleadoDh")
    public String saveEmpleado2(@ModelAttribute Empleado empleado, RedirectAttributes redirectAttributes) {
        if(empleadoService.saveOrUpdaateEmpleado(empleado)){
            redirectAttributes.addFlashAttribute("message","Registro Exitoso");
            return "redirect:/empleadosDh";
        }
        redirectAttributes.addFlashAttribute("message", "Error al registrar Empleado");
        return "redirect:/addEmpleado2";
    }
    @GetMapping("/addEmpleado2")
    public String addEmpleado2(@ModelAttribute("message") String message, Model model) {
        model.addAttribute("empleado", new Empleado());
        model.addAttribute("message", message);

        return "redirect:/empleadosDh";
    }


    @GetMapping("/empleadosDh")
    public String viewEmpleados(Model model){
        model.addAttribute("empleado", new Empleado());
        model.addAttribute("usuarios", usuarioService.getAllUsuario());

        model.addAttribute("empresas", empresaService.getAllEmpresa());
        model.addAttribute("listaEmpleados", empleadoService.getAllEmpleado());
        return "dashboard/empleadosDashboard";
    }

    @GetMapping("/eliminarEmpleado/{id}")
    public String eliminarEmpleado(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        empleadoService.deleteEmpleado(id.longValue());
        redirectAttributes.addFlashAttribute("message", "Empleado eliminado con éxito");
        return "redirect:/empleadosDh";
    }

    @GetMapping("/editarEmpleado/{id}")
    public String editarEmpleado(@PathVariable Integer id, Model model) {
        // Recupera el empleado que deseas editar por su ID
        Empleado empleado = empleadoService.getEmpleadoById(id.longValue());

        model.addAttribute("empleado", empleado);
        model.addAttribute("usuarios", usuarioService.getAllUsuario());

        model.addAttribute("empresas", empresaService.getAllEmpresa());

        return "Modal/empleadoEditar";
    }

    @PostMapping("/editSaveEmpleado")
    public String editSaveEmpleado(Empleado empleado, RedirectAttributes redirectAttributes) {
        if (empleadoService.saveOrUpdaateEmpleado(empleado)) {
            redirectAttributes.addFlashAttribute("message", "Empleado actualizado correctamente");
            return "redirect:/empleadosDh";
        }

        redirectAttributes.addFlashAttribute("message", "Error al actualizar Empleado");
        return "redirect:/editarEmpleado/" + empleado.getId();
    }
}
