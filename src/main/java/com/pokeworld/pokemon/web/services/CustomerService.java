package com.pokeworld.pokemon.web.services;

import com.pokeworld.pokemon.web.model.Customer;

import java.util.UUID;

public interface CustomerService {
    Customer getCustomerById(UUID customerId);

    void deleteCustomerById(UUID customerId);

    void updateCustomer(UUID customerId, Customer customer);

    Customer saveNewCustomer(Customer customer);
}
