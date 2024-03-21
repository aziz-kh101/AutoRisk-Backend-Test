package com.autorisk.vmapi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.autorisk.vmapi.model.User;
import com.autorisk.vmapi.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class VmApiApplication implements CommandLineRunner {

	private final PasswordEncoder passwordEncoder;
	private final UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(VmApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		if (userRepository.findByUsername("admin").isEmpty()) {
			User user = new User();
			user.setFirstName("admin");
			user.setLastName("admin");
			user.setUsername("admin");
			user.setRole("ADMIN");
			user.setPassword(passwordEncoder.encode("123456"));
			userRepository.save(user);
		}
	}

}
