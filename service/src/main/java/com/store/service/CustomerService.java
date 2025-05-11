package com.store.service;

import com.store.api.model.Customer;
import com.store.manager.entity.CustomerEntity;
import com.store.manager.repository.CustomerRepository;
import com.store.mapper.CustomerMapper;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public void createCustomer(Customer customer) {
        customerRepository.save(CustomerMapper.toEntity(customer));
    }

    public Customer getCustomerById(Long id) {
        Optional<CustomerEntity> customer = customerRepository.findById(id);
        return customer
                .map(CustomerMapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException("Customer not found"));
    }

    public List<Customer> getCustomers() {
        List<CustomerEntity> customers = customerRepository.findAll();
        return customers.stream()
                .map(CustomerMapper::toDto).collect(Collectors.toList());
    }

    @Transactional
    public void updateCustomer(Long customerId, Customer customer) {
        Customer oldCustomer = getCustomerById(customerId);
        if (oldCustomer.getName() != customer.getName()) {
            customerRepository.updateCustomerName(customerId, customer.getName());
        }
        if (oldCustomer.getPhonenumber() != customer.getPhonenumber()) {
            customerRepository.updateCustomerPhonenumber(customerId, customer.getPhonenumber());
        }
        if (oldCustomer.getAddress() != customer.getAddress()) {
            customerRepository.updateCustomerAddress(customerId, customer.getAddress());
        }
    }

    public void deleteCustomer(Long id) {
        if (!customerRepository.existsById(id)) {
            throw new EntityNotFoundException("Customer with id " + id + " not found");
        }
        customerRepository.deleteById(id);
    }

}
