package io.murad.email.manager.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@Entity(name = "SentEmail")
@Table(name = "sent_email")
@AllArgsConstructor
@NoArgsConstructor
public class Email {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "_from")
    private String from;

    @Column(name = "_to")
    private String to;

    @Column(name = "_cc", nullable = true)
    private String cc;

    @Column(name = "_subject")
    private String subject;

    @Column(name = "_body")
    @Lob
    private String body;
}
