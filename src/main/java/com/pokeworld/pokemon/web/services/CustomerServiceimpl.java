package com.pokeworld.pokemon.web.services;

import com.pokeworld.pokemon.web.model.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class CustomerServiceimpl implements CustomerService{

    @Override
    public Customer getCustomerById(UUID customerId){
        return  Customer.builder().name("rama").id(UUID.randomUUID()).build();
    }

    @Override
    public void deleteCustomerById(UUID customerId) {
        log.debug("Customer is deleted. Now Waht!!!");
    }

    @Override
    public void updateCustomer(UUID customerId, Customer customer) {
        log.debug("Customer is updated. Enjoy!!!");
    }

    @Override
    public Customer saveNewCustomer(Customer customer) {
        return Customer.builder().id(UUID.randomUUID())
                .build();
    }
}
