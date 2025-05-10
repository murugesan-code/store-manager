package com.store.mapper;

import com.store.api.model.Customer;
import com.store.api.model.Stock;
import com.store.manager.entity.CustomerEntity;
import com.store.manager.entity.StockEntity;

import java.util.Date;

public class CustomerMapper {
    public static CustomerEntity toEntity(Customer dto) {
        if (dto == null) return null;
        CustomerEntity entity = new CustomerEntity();
        entity.setName(dto.getName());
        entity.setPhonenumber(dto.getPhonenumber());
        entity.setAddress(dto.getAddress());
        entity.setCreatedDate(new Date());
        entity.setModifiedDate(new Date());
        return entity;
    }
    public static Customer toDto(CustomerEntity customerEntity){
        if(customerEntity== null) return null;
        Customer dto = new Customer();
        dto.setName(customerEntity.getName());
        dto.setPhonenumber(customerEntity.getPhonenumber());
        return  dto;
    }
}
