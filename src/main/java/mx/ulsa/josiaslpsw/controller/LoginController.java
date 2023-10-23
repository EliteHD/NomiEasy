package mx.ulsa.josiaslpsw.controller;

import jakarta.servlet.http.HttpServletRequest;
import mx.ulsa.josiaslpsw.model.Usuario;
import mx.ulsa.josiaslpsw.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/loginUser")
    public String viewLoginPage(Model model){
        return "login/loginUser";
    }

    @GetMapping("/register")
    public String viewRegisterPage(Model model){
        return "login/register";
    }

    @GetMapping("/redirect")
    public String redirect(HttpServletRequest request) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String role = auth.getAuthorities().toString();
        if (role.contains("administrador")) {
            return "redirect:/dashboard"; // Redirige a la página de administrador
        } else if (role.contains("usuario")) {
            return "redirect:/user1"; // Redirige a la página de usuario
        } else {
            return "redirect:/"; // Redirige a una página predeterminada si el rol no coincide
        }
    }



}
