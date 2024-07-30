package com.murilo.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.murilo.workshopmongo.domain.User;
import com.murilo.workshopmongo.repository.UserRepository;

@Service //Lembrar: Esta classe serve para encapsular a lógica do serviçp. No caso, os métodos usados para controlar os dados.
public class UserService {

	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}
}
