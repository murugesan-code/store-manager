package com.store.web;

import com.store.api.PurchasepriceApi;
import com.store.api.model.Purchaseprice;
import com.store.service.PurchasePriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PurchasePriceWeb implements PurchasepriceApi {

    @Autowired
    PurchasePriceService purchasePriceService;

    @Override
    public ResponseEntity<Void> createPurchasePrice(Purchaseprice purchaseprice) {
        purchasePriceService.createPurchasePrice(purchaseprice);
        return new ResponseEntity<Void>( HttpStatusCode.valueOf(200));
    }

    @Override
    public ResponseEntity<List<Purchaseprice>> getAllPurchasePrices() {
        return PurchasepriceApi.super.getAllPurchasePrices();
    }

    @Override
    public ResponseEntity<Purchaseprice> getPurchasePriceById(Long id) {
        return PurchasepriceApi.super.getPurchasePriceById(id);
    }

    @Override
    public ResponseEntity<Purchaseprice> updatePurchasePrice(Long id, Purchaseprice purchaseprice) {
        return PurchasepriceApi.super.updatePurchasePrice(id, purchaseprice);
    }

    @Override
    public ResponseEntity<Void> deletePurchasePrice(Long id) {
        return PurchasepriceApi.super.deletePurchasePrice(id);
    }
}
