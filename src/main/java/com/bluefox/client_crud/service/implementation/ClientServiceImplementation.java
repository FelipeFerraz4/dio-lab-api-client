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
        String cep = client.getClientAddress().getCep();
        Address address = addressRepository.findById(cep).orElseGet(() -> {
            Address newAddress = viaCepService.searchCep(cep);
            addressRepository.save(newAddress);
            return newAddress;
        });
        client.setClientAddress(address);
        clientRepository.save(client);
    }

    @Override
    public Iterable<Client> searchAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client searchById(Long clientId) {
        Optional<Client> client = clientRepository.findById(clientId);
        return client.get();
    }

    @Override
    public void insert(Client client) {
        saveClientwithCep(client);
    }

    @Override
    public void upadte(Long clientId, Client client) {
        Optional<Client> clientDB = clientRepository.findById(clientId);
        if (clientDB.isPresent()) {
            saveClientwithCep(client);
        }
    }

    @Override
    public void delete(Long clientId) {
        clientRepository.deleteById(clientId);
    }

}