package com.neweltechnologies.portfolio;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.neweltechnologies.portfolio.auth.AuthenticationService;
import com.neweltechnologies.portfolio.auth.RegisterRequest;

import static com.neweltechnologies.portfolio.users.Role.ADMIN;
import static com.neweltechnologies.portfolio.users.Role.MANAGER;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class PortfolioApplication {

	public static void main(String[] args) {
		SpringApplication.run(PortfolioApplication.class, args);
	}

	// @Bean
	// public CommandLineRunner commandLineRunner(
	// 		AuthenticationService service) {
	// 	return args -> {
	// 		var admin = RegisterRequest.builder()
	// 				.firstname("Admin")
	// 				.lastname("Admin")
	// 				.email("admin@mail.com")
	// 				.password("password")
	// 				.role(ADMIN)
	// 				.build();
	// 		System.out.println("Admin token: " + service.register(admin).getAccessToken());

	// 		var manager = RegisterRequest.builder()
	// 				.firstname("Admin")
	// 				.lastname("Admin")
	// 				.email("manager@mail.com")
	// 				.password("password")
	// 				.role(MANAGER)
	// 				.build();
	// 		System.out.println("Manager token: " + service.register(manager).getAccessToken());

	// 	};
	// }

}
