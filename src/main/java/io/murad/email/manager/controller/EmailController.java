package io.murad.email.manager.controller;

import io.murad.email.manager.model.Email;
import io.murad.email.manager.service.MailService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value ="/mail")
@AllArgsConstructor
public class EmailController {

    private final MailService mailService;

    @GetMapping(path = "/form")
    public String emailForm(Model model){
        Email email = new Email();
        model.addAttribute("email", email);
        return "email/emailForm";
    }
    @PostMapping(path = "/send")
    public String send(@ModelAttribute("email") Email email){
        mailService.sendMail(email);
        return "email/sentEmails";
    }
}
