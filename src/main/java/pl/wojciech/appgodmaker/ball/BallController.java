package pl.wojciech.appgodmaker.ball;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BallController {

    @GetMapping("/ball")
    public String getBall() {
        return "pitch";
    }
}
