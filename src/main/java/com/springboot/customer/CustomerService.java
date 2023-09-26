package com.springboot.customer;

import com.springboot.exception.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepo;
    private final Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);

    public CustomerService(CustomerRepository customerRepo) {
        this.customerRepo = customerRepo;
    }

    public Customer save(Customer customer) {
        return customerRepo.save(customer);
    }

    public List<Customer> getCustomers() {
        return customerRepo.findAll();
    }

    public Customer getCustomerWithId(Long id) {
        return customerRepo.findById(id)
                .stream()
                .filter(customer -> customer.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> {
                    NotFoundException notFoundException = new NotFoundException("customer with id " + id + " not found");
                    LOGGER.error("error in getting customer {}", id, notFoundException);
                    return notFoundException;
                });
    }

}
