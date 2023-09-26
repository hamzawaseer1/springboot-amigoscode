package com.springboot.customer;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/customers")
@Deprecated
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    @PostMapping
    public Customer saveCustomer(@RequestBody Customer customer) {
        System.out.println(customer);
        return customer;
    }


    @PutMapping
    public Customer updateCustomer(@RequestBody Customer customer) {
        System.out.println(customer);
        return customer;
    }

    @DeleteMapping("{customerId}")
    public void deleteCustomer(@PathVariable("customerId") Long id) {
        System.out.println("Deleting customer with this id " + id);
    }

    @GetMapping("{customerId}")
    public Customer getCustomer(@PathVariable("customerId") Long id) {
        return customerService.getCustomerWithId(id);
    }
}
