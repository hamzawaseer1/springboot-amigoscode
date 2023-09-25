package com.springboot.customer;

import java.util.Collections;
import java.util.List;

public class CustomerRepository implements CustomerRepo {

    public List<Customer> getCustomers() {
        //TODO : implement real database
        return Collections.emptyList();
    }
}
