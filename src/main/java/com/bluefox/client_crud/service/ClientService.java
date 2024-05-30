package com.bluefox.client_crud.service;

import com.bluefox.client_crud.model.Client;

public interface ClientService {
    Iterable<Client> searchAll();

    Client searchById(Long clientId);

    void insert(Client client);

    void update(Long clientId, Client client);

    void delete(Long clientId);
}
