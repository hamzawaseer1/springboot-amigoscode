package com.springboot.customer;

import jakarta.validation.Valid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v2/customers")
public class CustomerControllerV2 {

    private final CustomerService customerService;
    private static final Logger LOGGER = LogManager.getLogger(CustomerControllerV2.class);

    public CustomerControllerV2(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> getCustomers() {
        LOGGER.info("Request for getting all customers {}", "--------------");
        return customerService.getCustomers();
    }

    @PostMapping
    public ResponseEntity<Customer> saveCustomer(@Valid @RequestBody Customer customer) {
        LOGGER.info("Request for saving customer {}", customer);
        var savedCustomer = customerService.save(customer);

        return new ResponseEntity<>(savedCustomer, HttpStatus.OK);
    }


    @PutMapping
    public Customer updateCustomer(@RequestBody Customer customer) {
        LOGGER.info("Request for updating customer {}", customer);
        return customer;
    }

    @DeleteMapping("{customerId}")
    public void deleteCustomer(@PathVariable("customerId") Long id) {
        LOGGER.info("Request for deleting customer with id {}", id);
    }

    @GetMapping("{customerId}")
    public Customer getCustomer(@PathVariable("customerId") Long id) {
        Customer customer = customerService.getCustomerWithId(id);
        LOGGER.info("Request for getting customer with id {}", customer);
        return customer;
    }

}
