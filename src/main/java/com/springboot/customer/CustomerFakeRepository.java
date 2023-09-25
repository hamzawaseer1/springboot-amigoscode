package com.springboot.customer;

import java.util.List;

public class CustomerFakeRepository implements CustomerRepo {
    @Override
    public List<Customer> getCustomers() {
        return List.of(
                new Customer(1L, "Ali Hamza", "password123"),
                new Customer(2L, "Shan Javed", "password123")
        );
    }
}
