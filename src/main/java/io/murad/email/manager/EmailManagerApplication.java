package io.murad.email.manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"io.murad.email.manager.repository"})
public class EmailManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmailManagerApplication.class, args);
	}

}
