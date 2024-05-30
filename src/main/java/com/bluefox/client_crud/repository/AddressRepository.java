package com.bluefox.client_crud.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bluefox.client_crud.model.Address;

@Repository
public interface AddressRepository extends CrudRepository<Address, String> {
    
}
