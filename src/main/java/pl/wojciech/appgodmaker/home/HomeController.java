package pl.wojciech.appgodmaker.home;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.wojciech.appgodmaker.user.CurrentUser;
import pl.wojciech.appgodmaker.user.User;


@Controller
@RequestMapping("")
public class HomeController {

    @GetMapping(value = "/", produces = "text/html; charset=utf-8")
    public String welcomePage() {
        return "home";
    }
}
