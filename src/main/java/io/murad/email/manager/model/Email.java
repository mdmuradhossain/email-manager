package io.murad.email.manager.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Email {
    private String from;
    private String to;
    private String cc;
    private String subject;
    private String body;
}
