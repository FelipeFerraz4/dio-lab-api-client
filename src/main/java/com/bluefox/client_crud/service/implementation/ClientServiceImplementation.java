package com.bluefox.client_crud.service.implementation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluefox.client_crud.model.Address;
import com.bluefox.client_crud.model.Client;
import com.bluefox.client_crud.repository.AddressRepository;
import com.bluefox.client_crud.repository.ClientRepository;
import com.bluefox.client_crud.service.ClientService;
import com.bluefox.client_crud.service.ViaCepService;

/**
 * ClientServiceImplementation
 */
@Service
public class ClientServiceImplementation implements ClientService {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private ViaCepService viaCepService;

    private void saveClientwithCep(Client client) {
        String cep = client.getAddress().getCep();
        Address address = addressRepository.findById(cep).orElseGet(() -> {
            Address newAddress = viaCepService.searchCep(cep);
            addressRepository.save(newAddress);
            return newAddress;
        });
        client.setAddress(address);
        clientRepository.save(client);
    }

    @Override
    public Iterable<Client> searchAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client searchById(Long clientId) {
        Optional<Client> client = clientRepository.findById(clientId);
        return client.orElse(null);
    }

    @Override
    public void insert(Client client) {
        System.out.println(client);
        saveClientwithCep(client);
    }

    @Override
    public void update(Long clientId, Client client) {
        Optional<Client> clientDB = clientRepository.findById(clientId);
        if (clientDB.isPresent()) {
            client.setId(clientId);
            saveClientwithCep(client);
        }
    }

    @Override
    public void delete(Long clientId) {
        clientRepository.deleteById(clientId);
    }
}
