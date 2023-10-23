package mx.ulsa.josiaslpsw.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping({"/","/home"})
    public String home(){
        return "index";
    }

    @GetMapping("/dashboard")
    public String dash(){
        return "dashboard/adminDasboard";
    }

    @GetMapping("/usuarios")
    public String usuarios(){
        return "dashboard/usuariosDashboard";
    }
    @GetMapping("/empleados")
    public String empleados(){
        return "dashboard/empleadosDashboard";
    }
    @GetMapping("/roles")
    public String roles(){
        return "dashboard/rolesDashboard";
    }
    @GetMapping("/empresas")
    public String empresas(){
        return "dashboard/empresasDashboard";
    }
    @GetMapping("/user1")
    public String dash1(){
        return "index-back";
    }

}
