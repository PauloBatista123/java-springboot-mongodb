package com.aula.workshopmongo.resource;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.aula.workshopmongo.domain.User;
import com.aula.workshopmongo.dto.UserDTO;
import com.aula.workshopmongo.services.UserService;

@RestController
@RequestMapping("/users")
public class UserResource {
	
	@Autowired
	private UserService userService;
	
	@GetMapping()
	public ResponseEntity<List<UserDTO>> findAll(){
		List<UserDTO> listDto = userService.findAll().stream().map(item -> new UserDTO(item)).collect(Collectors.toList());
		return ResponseEntity.ok(listDto);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable("id") String id){
		return ResponseEntity.ok(new UserDTO(userService.findById(id)));
	}
	
	@PostMapping()
	public ResponseEntity<Void> insert(@RequestBody UserDTO user){
		User newUser = userService.insert(userService.fromDTO(user));
		
		return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newUser.getId()).toUri()).build();
	}

}
