package com.omerfaruksen.vetSystem.controller;


import com.omerfaruksen.vetSystem.dto.request.CustomerRequestDto;
import com.omerfaruksen.vetSystem.entity.Customer;
import com.omerfaruksen.vetSystem.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    public final CustomerService customerService;

    @GetMapping
    public List<Customer> findAllCustomers (){
        return customerService.findAllCustomers();
    }

    @GetMapping("/{id}")
    public Customer findCustomerById (@PathVariable Long id){
        return customerService.findCustomerById(id);
    }

    @GetMapping("/searchByName")
    public List<Customer> findCustomersByName (@RequestParam String name){
        return customerService.findCustomersByName(name);
    }

    @PostMapping
    public Customer createCustomer (@RequestBody CustomerRequestDto customerRequestDto){
        return customerService.createCustomer(customerRequestDto);
    }

    @PutMapping("/{id}")
    public Customer updateCustomer (@PathVariable Long id, @RequestBody CustomerRequestDto customerRequestDto){
        return customerService.updateCustomer(id,customerRequestDto);
    }

    @DeleteMapping("/{id}")
    public String deleteCustomer(@PathVariable Long id){
        return customerService.deleteCustomer(id);
    }

}