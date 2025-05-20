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
        return new ResponseEntity<Void>(HttpStatusCode.valueOf(200));
    }

    @Override
    public ResponseEntity<List<Purchaseprice>> getAllPurchasePrices() {
        return new ResponseEntity<>(purchasePriceService.getAllPurchasePrices(), HttpStatusCode.valueOf(200));
    }

    @Override
    public ResponseEntity<Purchaseprice> getPurchasePriceById(Long id) {
        return new ResponseEntity<>(purchasePriceService.getPurchasePriceById(id), HttpStatusCode.valueOf(200));
    }

    @Override
    public ResponseEntity<Purchaseprice> updatePurchasePrice(Long id, Purchaseprice purchaseprice) {
        purchasePriceService.updatePurchasePrice(id, purchaseprice);
        return new ResponseEntity<>(getPurchasePriceById(id).getBody(),HttpStatusCode.valueOf(200));
    }

    @Override
    public ResponseEntity<Void> deletePurchasePrice(Long id) {
        purchasePriceService.deletePurchasePrice(id);
        return new ResponseEntity<>(HttpStatusCode.valueOf(200));
    }
}
