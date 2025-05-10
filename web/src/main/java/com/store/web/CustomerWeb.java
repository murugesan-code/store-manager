package com.store.web;

import com.store.api.CustomerApi;
import com.store.api.model.Customer;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class CustomerWeb implements CustomerApi {



    @Override
    public ResponseEntity<List<Customer>> getAllCustomers() {

        return CustomerApi.super.getAllCustomers();
    }

    @Override
    public ResponseEntity<Customer> getCustomerById(Long id) {
        return CustomerApi.super.getCustomerById(id);
    }

    @Override
    public ResponseEntity<Void> createCustomer(Customer customer) {
        return CustomerApi.super.createCustomer(customer);
    }

    @Override
    public ResponseEntity<Customer> updateCustomer(Long id, Customer customer) {
        return CustomerApi.super.updateCustomer(id, customer);
    }

    @Override
    public ResponseEntity<Void> deleteCustomer(Long id) {
        return CustomerApi.super.deleteCustomer(id);
    }
}
