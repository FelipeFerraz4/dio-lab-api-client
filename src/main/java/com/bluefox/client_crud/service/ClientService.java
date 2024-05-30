package com.bluefox.client_crud.service;

import com.bluefox.client_crud.model.Client;
import java.lang.Iterable;

public interface ClientService {
    Iterable<Client> searchAll();

    Client searchById(Long clientId);

    void insert(Client client);

    void upadte(Long clientId, Client client);

    void delete(Long clientId);
}
