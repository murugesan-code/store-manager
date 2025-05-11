
package com.store.service;

import com.store.api.model.Supplier;
import com.store.manager.entity.SupplierEntity;
import com.store.manager.repository.SupplierRepository;
import com.store.mapper.SupplierMapper;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SupplierService {
    @Autowired
    private SupplierRepository supplierRepository;

    public void createSupplier(Supplier supplier) {
        supplierRepository.save(SupplierMapper.toEntity(supplier));
    }

    public Supplier getSupplierById(Long id) {
        Optional<SupplierEntity> supplier = supplierRepository.findById(id);
        return supplier
                .map(SupplierMapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException("Supplier not found"));
    }

    public List<Supplier> getSuppliers() {
        List<SupplierEntity> suppliers = supplierRepository.findAll();
        return suppliers.stream()
                .map(SupplierMapper::toDto).collect(Collectors.toList());
    }

    @Transactional
    public void updateSupplier(Long supplierId, Supplier supplier) {
        Supplier oldsupplier = getSupplierById(supplierId);
        /* if (oldsupplier.getName() != supplier.getName()) {
            supplierRepository.updateSupplierName(supplierId, supplier.getName());
        }*/
       /* if (oldsupplier.getPhonenumber() != supplier.getPhonenumber()) {
            supplierRepository.updateSupplierPhonenumber(supplierId, supplier.getPhonenumber());
        }
        if (oldsupplier.getAddress() != supplier.getAddress()) {
            supplierRepository.updateSupplierAddress(supplierId, supplier.getAddress());
        }*/
    }

    public void deleteSupplier(Long id) {
        if (!supplierRepository.existsById(id)) {
            throw new EntityNotFoundException("Supplier with id " + id + " not found");
        }
        supplierRepository.deleteById(id);
    }

}

