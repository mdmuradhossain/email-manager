package io.murad.email.manager.service;

import io.murad.email.manager.model.Email;
import io.murad.email.manager.repository.EmailRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmailService {

    private final EmailRepository emailRepository;
    private final MailService mailService;

    public void sendAndStoreEmail(Email email){
        mailService.sendMail(email);
        emailRepository.save(email);
    }
}
