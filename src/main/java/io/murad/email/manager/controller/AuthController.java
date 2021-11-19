package io.murad.email.manager.controller;

import io.murad.email.manager.model.User;
import io.murad.email.manager.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping(path = "/auth")
public class AuthController {

    private final UserService userService;

    @GetMapping(path = "/login")
    public String signinPage(){
        return "users/signin";
    }

    @GetMapping(path = "/signup")
    public String signupForm(Model model){
        model.addAttribute("user",new User());
        return "users/signup";
    }

    @PostMapping(path = "/register")
    public String register(@ModelAttribute("user") User user){
        userService.register(user);
        return "users/signin";
    }
}
