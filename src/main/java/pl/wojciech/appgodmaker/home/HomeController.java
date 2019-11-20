package pl.wojciech.appgodmaker.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class HomeController {

    @GetMapping(value = "/", produces = "text/html; charset=utf-8")
    public String welcomePage() {
        return "home";
    }
}
