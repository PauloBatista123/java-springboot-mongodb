package com.aula.workshopmongo.resource;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aula.workshopmongo.dto.UserDTO;
import com.aula.workshopmongo.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired
	private UserService userService;
	
	@GetMapping()
	public ResponseEntity<List<UserDTO>> findAll(){
		List<UserDTO> listDto = userService.findAll().stream().map(item -> new UserDTO(item)).collect(Collectors.toList());
		return ResponseEntity.ok(listDto);
	}

}
