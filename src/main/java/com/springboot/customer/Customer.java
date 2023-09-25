package com.springboot.customer;


import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

@Component
public class Customer {
    //    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String name;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Customer() {
    }

    public Customer(Long id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    @JsonProperty("customerId")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
