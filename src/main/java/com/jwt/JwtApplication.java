package com.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.jwt.model.User;
import com.jwt.repo.UserRepository;

@SpringBootApplication
public class JwtApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	private PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	public void createUser() {
		User user = new User();
		user.setId(1);
		user.setUsername("Akash");
		user.setEmail("akashpathak@gmail.com");
		user.setPassword(passwordEncoder().encode("Akash1808"));
		user.setRole("ROLE_ADMIN");
		user.setEnabled(true);

		User save = this.userRepository.save(user);
		System.out.println(save);
	}

	public static void main(String[] args) {
		SpringApplication.run(JwtApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		createUser();
	}
}
