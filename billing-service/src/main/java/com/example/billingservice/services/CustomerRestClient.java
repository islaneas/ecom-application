package com.example.billingservice.services;

import com.example.billingservice.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerRestClient {
    @GetMapping(value = "/customers/{id}?projection=fullcustomer",headers = { })
    // @GetMapping(path = "/customers/{id}")
    Customer findCustomerById(@PathVariable Long id);

    //public Customer customerById(@PathVariable Long id);
    @GetMapping("/customers?projection=fullcustomer")
    public PagedModel<Customer> allCustomers();

}