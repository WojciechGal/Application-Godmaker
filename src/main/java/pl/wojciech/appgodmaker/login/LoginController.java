package pl.wojciech.appgodmaker.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String loginUserGet() {
        return "admin/login";
    }
}
