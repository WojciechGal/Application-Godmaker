package pl.wojciech.appgodmaker.user;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {

//    @Autowired
//    private UserService userService;
//
//    @GetMapping(value = "/add")
//    public String addUser(Model model) {
//        User user = new User();
//        user.setCredit(100.00);
//        user.setSuperUser(0);
//        model.addAttribute("user", user);
//        return "user";
//    }
//
//    @PostMapping("/add")
//    public String addUser(@Valid User user, BindingResult result) {
//        if (result.hasErrors()) {
//            return "user";
//        }
//        userService.saveUser(user);
//        return "redirect:/users/all";
//    }
//
//    @GetMapping(value = "/all")
//    public String getAllUsers(Model model) {
//        List<User> users = userService.getAllUsers();
//        model.addAttribute("users", users);
//        return "userList";
//    }
//
//    @GetMapping(value = "/update/{id}")
//    public String updateUser(@PathVariable Long id, Model model) {
//        User user = userService.findUserById(id);
//        model.addAttribute("user", user);
//        return "user";
//    }
//
//    @PostMapping("/update/{id}")
//    public String updateUser(@Valid User user, BindingResult result) {
//        if (result.hasErrors()) {
//            return "user";
//        }
//        userService.saveUser(user);
//        return "redirect:/users/all";
//    }
//
//    @GetMapping(value = "/delete/{id}")
//    public String deleteUser(@PathVariable Long id) {
//        userService.deleteUser(id);
//        return "redirect:/users/all";
//    }


    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/add")
    public String addUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "admin/registration";
    }

    @PostMapping("/add")
    public String addUser(@Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "admin/registration";
        }

        userService.saveUser(user);
        return "redirect:/login";
    }

    @GetMapping("/details")
    public String checkUser(@AuthenticationPrincipal CurrentUser customUser, Model model) {
        User user = customUser.getUser();

        model.addAttribute("user", userService.findByUserName(user.getUsername()));

        return "userInfo";
    }







}
