package com.kononikhin.springdemo.rest;


import com.kononikhin.springdemo.customException.CustomNotFoundException;
import com.kononikhin.springdemo.entity.Customer;
import com.kononikhin.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerRestController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/getCustomers")
    public List<Customer> getCustomers() {

        return customerService.getCustomers();

    }

    @GetMapping("/getCustomers/{customerId}")
    public Customer getCustomers(@PathVariable int customerId) {
        Customer customer = customerService.getCustomer(customerId);

        if (customer == null) {
            throw new CustomNotFoundException("Customer not found " + customerId);
        }

        return customerService.getCustomer(customerId);

    }

    @PutMapping("/customers")
    public Customer updateCustomer(@RequestBody Customer customer) {

        customerService.saveCustomer(customer);

        return customer;
    }

    @DeleteMapping("/customers/{customerId}")
    public String deteleCustomer(@PathVariable int customerId) {

        customerService.deleteCustomer(customerId);

        return "Customer has been deletet with id=" + customerId;
    }

    @PostMapping("/customers")
    public Customer addCustomer(@RequestBody Customer customer) {

        customer.setId(0);

        customerService.saveCustomer(customer);

        return customer;
    }
}
