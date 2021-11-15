package io.murad.email.manager.controller;

import io.murad.email.manager.model.Email;
import io.murad.email.manager.service.EmailService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/mail")
@AllArgsConstructor
public class EmailController {

    private final EmailService emailService;

    @GetMapping()
    public String dashboard() {
        return "email/dashboard";
    }

    @GetMapping(path = "/form")
    public String emailForm(Model model) {
        Email email = new Email();
        model.addAttribute("email", email);
        return "email/emailForm";
    }

    @PostMapping(path = "/send")
    public String send(@ModelAttribute("email") Email email) {
        emailService.sendAndStoreEmail(email);
        return "email/sentEmails";
    }

    @GetMapping(path = "/sent")
    public String sentMails(Model model){
        model.addAttribute("sentEmails",emailService.findAllSentEmails());
        return "email/sentEmails";

    }

    @GetMapping(path = "/sent/{id}")
    public String getEmail(@PathVariable("id") Long id,Model model){
        model.addAttribute("email",emailService.getEmail(id));
        return "email/displayEmail";
    }
}
