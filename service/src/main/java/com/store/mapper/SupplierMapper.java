package com.store.mapper;

import com.store.api.model.Supplier;
import com.store.manager.entity.SupplierEntity;

import java.util.Date;

public class SupplierMapper {
    public static SupplierEntity toEntity(Supplier dto) {
        if (dto == null) return null;
        SupplierEntity entity = new SupplierEntity();
        entity.setName(dto.getName());
        entity.setPhonenumber(dto.getPhonenumber());
        entity.setAddress(dto.getAddress());
        entity.setCreatedDate(new Date());
        entity.setModifiedDate(new Date());
        return entity;
    }
    public static Supplier toDto(SupplierEntity customerEntity){
        if(customerEntity== null) return null;
        Supplier dto = new Supplier();
        dto.setName(customerEntity.getName());
        dto.setPhonenumber(customerEntity.getPhonenumber());
        dto.setAddress(customerEntity.getAddress());
        return  dto;
    }
}
