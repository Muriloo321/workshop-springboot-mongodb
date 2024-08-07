package com.murilo.workshopmongo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.murilo.workshopmongo.domain.Post;
import com.murilo.workshopmongo.repository.PostRepository;
import com.murilo.workshopmongo.services.exception.ObjectNotFoundException;

@Service //Lembrar: Esta classe serve para encapsular a lógica do serviçp. No caso, os métodos usados para controlar os dados.
public class PostService {

	@Autowired
	private PostRepository repo;
	
	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
}
