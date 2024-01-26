package com.aula.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.aula.workshopmongo.domain.User;
import com.aula.workshopmongo.repository.UserRepository;

@Configuration
public class Instatiation implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		
		User maria = new User(null, "Maria Joana", "joana@gmail.com");
		User jose = new User(null, "Jose Rodrigues", "jose@gmail.com");
		User vitor = new User(null, "Vitor Henrique", "vitor@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, jose, vitor));
	}

}
