package mx.ulsa.josiaslpsw.controller;

import mx.ulsa.josiaslpsw.model.Usuario;
import mx.ulsa.josiaslpsw.model.Rol;

import mx.ulsa.josiaslpsw.service.RolService;
import mx.ulsa.josiaslpsw.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;
    @Autowired
    RolService rolService; // Supongo que tienes un servicio para los roles

    @Autowired
    private PasswordEncoder passwordEncoder;
    @GetMapping("/addUser")
    public String addUser(@ModelAttribute("message") String message, Model model) {
        model.addAttribute("usuario", new Usuario());
        model.addAttribute("message", message);

        return "login/register";
    }
    @PostMapping("/saveUser")
    public String saveUser(Usuario usuario, RedirectAttributes redirectAttributes) {
        Rol usuarioRol = rolService.findByNombre("administrador").orElse(null);

        if (usuarioRol != null) {
            usuario.setRol(usuarioRol);
        } else {
            // Si no existe el rol, crearlo
            usuarioRol = new Rol();
            usuarioRol.setNombre("administrador");
            rolService.saveOrUpdateRol(usuarioRol);
            usuario.setRol(usuarioRol);

        }

        // Codificar la contraseña antes de guardarla
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));

        if (usuarioService.saveOrUpdaateUsuario(usuario)) {
            redirectAttributes.addFlashAttribute("message", "Registro Exitoso");
            return "redirect:/loginUser";
        }

        redirectAttributes.addFlashAttribute("message", "Error al registrar usuario");
        return "redirect:/addUsuario";
    }

    @PostMapping("/saveUserDh")
    public String saveUsuario2(@ModelAttribute Usuario usuario, RedirectAttributes redirectAttributes) {
        // Codificar la contraseña antes de guardarla
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));

        if(usuarioService.saveOrUpdaateUsuario(usuario)){
            redirectAttributes.addFlashAttribute("message","Registro Exitoso");
            return "redirect:/usuariosDh";
        }
        redirectAttributes.addFlashAttribute("message", "Error al registrar Categoria");
        return "redirect:/addUser2";
    }
    @GetMapping("/addUser2")
    public String addUser2(@ModelAttribute("message") String message, Model model) {
        model.addAttribute("usuario", new Usuario());
        model.addAttribute("message", message);

        return "redirect:/usuariosDh";
    }


    @GetMapping("/usuariosDh")
    public String viewUsuarios(Model model){
        model.addAttribute("usuario", new Usuario());

        model.addAttribute("roles", rolService.getAllRol());
        model.addAttribute("listaUsuarios", usuarioService.getAllUsuario());
        return "dashboard/usuariosDashboard";
    }

    @GetMapping("/eliminarUsuario/{id}")
    public String eliminarUsuario(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        usuarioService.deleteUsuario(id.longValue());
        redirectAttributes.addFlashAttribute("message", "Usuario eliminado con éxito");
        return "redirect:/usuariosDh";
    }

    @GetMapping("/editarUsuario/{id}")
    public String editarUsuario(@PathVariable Integer id, Model model) {
        // Recupera el usuario que deseas editar por su ID
        Usuario usuario = usuarioService.getUsuarioById(id.longValue());

        model.addAttribute("usuario", usuario);

        model.addAttribute("roles", rolService.getAllRol());

        return "Modal/usuariosModal";
    }

    @PostMapping("/editSaveCategoria")
    public String editSaveCategoria(Usuario usuario, RedirectAttributes redirectAttributes) {
        if (usuarioService.saveOrUpdaateUsuario(usuario)) {
            redirectAttributes.addFlashAttribute("message", "Categoria actualizado correctamente");
            return "redirect:/usuariosDh";
        }

        redirectAttributes.addFlashAttribute("message", "Error al actualizar Categoria");
        return "redirect:/editarUsuario/" + usuario.getIdUsuario();
    }

}
