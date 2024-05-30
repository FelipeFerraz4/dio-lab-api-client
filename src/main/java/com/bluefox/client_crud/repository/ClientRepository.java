package com.bluefox.client_crud.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bluefox.client_crud.model.Client;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {
    
}
