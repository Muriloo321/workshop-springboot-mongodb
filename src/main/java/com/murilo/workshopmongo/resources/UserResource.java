package com.murilo.workshopmongo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.murilo.workshopmongo.domain.User;
import com.murilo.workshopmongo.dto.UserDTO;
import com.murilo.workshopmongo.services.UserService;

@RestController // Para avisar que esta classe cuidará de requisições e respostas HTTP.
				// Literalmente um controlador REST
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserService service;

	@GetMapping // Declarar que este método é um endpoint rest no caminho /users
	public ResponseEntity<List<UserDTO>> FindAll() {
		List<User> list = service.findAll();
		List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
}
