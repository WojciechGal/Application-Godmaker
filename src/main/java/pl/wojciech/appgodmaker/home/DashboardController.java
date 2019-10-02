package pl.wojciech.appgodmaker.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.wojciech.appgodmaker.user.CurrentUser;
import pl.wojciech.appgodmaker.user.User;
import pl.wojciech.appgodmaker.user.UserService;


@Controller
public class DashboardController {

    @Autowired
    UserService userService;


    @GetMapping(value = "/dashboard", produces = "text/html; charset=utf-8")
    public String dashboard(@AuthenticationPrincipal CurrentUser customUser, Model model) {
        User user = customUser.getUser();
        model.addAttribute("user", userService.findByUserName(user.getUsername()));
        return "dashboard";
    }
}
