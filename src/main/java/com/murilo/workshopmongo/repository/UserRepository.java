package com.murilo.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.murilo.workshopmongo.domain.User;

@Repository //Usada para indicar que essa classe será responsável pelo acesso e manipulação de dados do banco de dados
public interface UserRepository extends MongoRepository<User, String>{

}
