package com.walmir.gestorfinanceiro.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.walmir.gestorfinanceiro.domain.model.User;
import com.walmir.gestorfinanceiro.repository.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {

		User u1 = new User(null, "Jonas", "jonasmail.com", "123455");
		User u2 = new User(null, "Josias", "josiasmail.com", "123456");

		userRepository.saveAll(Arrays.asList(u1, u2));
	}

}
