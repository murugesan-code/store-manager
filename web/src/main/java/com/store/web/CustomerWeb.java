package com.store.web;

import com.store.api.CustomerApi;
import com.store.api.model.Customer;
import com.store.service.CustomerService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerWeb implements CustomerApi {

    @Autowired
    CustomerService customerService;

    @Override
    public ResponseEntity<List<Customer>> getAllCustomers() {
        return new ResponseEntity<>(customerService.getCustomers(), HttpStatusCode.valueOf(200));
    }

    @Override
    public ResponseEntity<Customer> getCustomerById(Long id) {
        return new ResponseEntity<>(customerService.getCustomerById(id), HttpStatusCode.valueOf(200));
    }

    @Override
    public ResponseEntity<Void> createCustomer(Customer customer) {
        customerService.createCustomer(customer);
        return new ResponseEntity<>(HttpStatusCode.valueOf(200));
    }

    @Override
    public ResponseEntity<Customer> updateCustomer(Long id, Customer customer) {
        customerService.updateCustomer(id, customer);
        return new ResponseEntity<>(customerService.getCustomerById(id), HttpStatusCode.valueOf(200));
    }

    @Override
    public ResponseEntity<Void> deleteCustomer(Long id) {
        customerService.deleteCustomer(id);
        return new ResponseEntity<>(HttpStatusCode.valueOf(200));
    }
}
