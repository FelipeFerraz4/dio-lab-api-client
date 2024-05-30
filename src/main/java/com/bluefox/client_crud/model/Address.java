package com.bluefox.client_crud.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Address {
    
    @Id
    private String cep;
    private String street;
    private String district;
    private String city;
    private String state;
    private String ibge;
    private String gia;
    private String ddd;
    private String siafi;
    
    public String getCep() {
        return cep;
    }
    public String getStreet() {
        return street;
    }
    public String getDistrict() {
        return district;
    }
    public String getCity() {
        return city;
    }
    public String getState() {
        return state;
    }
    public String getIbge() {
        return ibge;
    }
    public String getGia() {
        return gia;
    }
    public String getDdd() {
        return ddd;
    }
    public String getSiafi() {
        return siafi;
    }

    
}
