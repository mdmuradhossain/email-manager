package io.murad.email.manager.repository;

import io.murad.email.manager.model.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface EmailRepository extends JpaRepository<Email,Long> {
}
