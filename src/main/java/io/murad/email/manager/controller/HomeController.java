package io.murad.email.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping(value = "/")
    public String home() {
        return "index";
    }

    @GetMapping(path = "/about")
    public String about() {
        return "pages/about";
    }

    @GetMapping(path = "/contact")
    public String contact() {
        return "pages/contact";
    }
}
