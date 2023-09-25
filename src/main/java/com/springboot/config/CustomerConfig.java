package com.springboot.config;

import com.springboot.customer.CustomerFakeRepository;
import com.springboot.customer.CustomerRepo;
import com.springboot.customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerConfig {

    @Value("${app.useFakeCustomerRepo:false}")
    private Boolean useFakeCustomerRepo;

    @Bean
    CustomerRepo customerRepo() {
        System.out.println("useFakeCustomerRepo = " + useFakeCustomerRepo);
        return useFakeCustomerRepo ?
                new CustomerFakeRepository() :
                new CustomerRepository();
    }


}
