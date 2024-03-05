package todolist.todolistspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class Logincontroller {

    @GetMapping("login")
    public String login(Model model){
        model.addAttribute("data", " 로그인 해주세요.");
        return "login";
    }
}
