package com.bluefox.client_crud.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Client {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long clientId;
    private String clientName;
    @ManyToOne
    private Address clientAddress;
    
    public Long getClientId() {
        return clientId;
    }
    
    public String getClientName() {
        return clientName;
    }

    public Address getClientAddress() {
        return clientAddress;
    }

    public void setClientAddress(Address clientAddress) {
        this.clientAddress = clientAddress;
    }    
    
}
