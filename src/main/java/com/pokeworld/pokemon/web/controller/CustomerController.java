package com.pokeworld.pokemon.web.controller;

import com.pokeworld.pokemon.web.model.Customer;
import com.pokeworld.pokemon.web.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v1/customer")
@RestController
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<Customer> getCustomer(@PathVariable("customerId") UUID customerId){
        return new ResponseEntity<>(customerService.getCustomerById(customerId), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity getCustomer(@RequestBody Customer customer){
        Customer savedDto=customerService.saveNewCustomer(customer);
        HttpHeaders headers=new HttpHeaders();
        headers.add("Location","/api/v1/customer/"+savedDto.getId().toString());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping("/{customerId}")
    public ResponseEntity updateCustomer(@PathVariable("customerId") UUID customerId,@RequestBody Customer customer){
        customerService.updateCustomer(customerId,customer);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{customerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomerrById(@PathVariable("customerId") UUID customerId){
        customerService.deleteCustomerById(customerId);
    }
}
