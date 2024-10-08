package com.murilo.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.murilo.workshopmongo.domain.User;
import com.murilo.workshopmongo.dto.UserDTO;
import com.murilo.workshopmongo.repository.UserRepository;
import com.murilo.workshopmongo.services.exception.ObjectNotFoundException;

@Service //Lembrar: Esta classe serve para encapsular a lógica do serviçp. No caso, os métodos usados para controlar os dados.
public class UserService {

	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}

	public User update(User obj) {
		Optional<User> optionalUser = repo.findById(obj.getId());
		if (optionalUser.isPresent()) {
	        User newObj = optionalUser.get();
	        updateData(newObj, obj);
	        return repo.save(newObj);
	    } else {
	        throw new ObjectNotFoundException("Usuário não encontrado com id: " + obj.getId());
	    }
	}
	
	private void updateData(User newObj, User obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
	}
	
	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
}
