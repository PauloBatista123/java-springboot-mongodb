package com.aula.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aula.workshopmongo.domain.User;
import com.aula.workshopmongo.repository.UserRepository;
import com.aula.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	public User findById(String id) {
		Optional<User> user = userRepository.findById(id);
		
		if(user.isEmpty()) {
			throw new ObjectNotFoundException("Não encontramos usuários com o ID informado");
		}
		
		return user.get();
	}

}
