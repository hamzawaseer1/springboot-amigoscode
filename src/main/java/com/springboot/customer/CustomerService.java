package com.springboot.customer;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepo customerRepo;

    public CustomerService(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    public List<Customer> getCustomers() {
        return customerRepo.getCustomers();
    }

}
