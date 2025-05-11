package com.store.web;

import com.store.api.SupplierApi;
import com.store.api.model.Supplier;
import com.store.service.SupplierService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SupplierWeb implements SupplierApi {

    @Autowired
    SupplierService supplierService;

    @Override
    public ResponseEntity<List<Supplier>> getAllSuppliers() {
        return new ResponseEntity<>(supplierService.getSuppliers(), HttpStatusCode.valueOf(200));
    }

    @Override
    public ResponseEntity<Supplier> getSupplierById(Long id) {
        return new ResponseEntity<>(supplierService.getSupplierById(id), HttpStatusCode.valueOf(200));
    }

    @Override
    public ResponseEntity<Void> createSupplier(Supplier supplier) {
        supplierService.createSupplier(supplier);
        return new ResponseEntity<>(HttpStatusCode.valueOf(200));
    }

    @Override
    public ResponseEntity<Supplier> updateSupplier(Long id, Supplier supplier) {
        supplierService.updateSupplier(id, supplier);
        return new ResponseEntity<>(supplierService.getSupplierById(id), HttpStatusCode.valueOf(200));
    }

    @Override
    public ResponseEntity<Void> deleteSupplier(Long id) {
        supplierService.deleteSupplier(id);
        return new ResponseEntity<>(HttpStatusCode.valueOf(200));
    }
}
