package com.store.web;

import com.store.api.PurchasepriceApi;
import com.store.api.StockpurchaseApi;
import com.store.api.model.Purchaseprice;
import com.store.service.StockPurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StockPurchase implements StockpurchaseApi {

    @Autowired
    StockPurchaseService purchasePriceService;

    @Override
    public ResponseEntity<Void> createStockPurchase(com.store.api.model.StockPurchase stockPurchase) {
        purchasePriceService.createStockPurchase(stockPurchase);
        return new ResponseEntity<>(HttpStatusCode.valueOf(200));
    }
    /*
    @Override
    public ResponseEntity<List<Purchaseprice>> getAllStockPurchases() {
        return new ResponseEntity<>(purchasePriceService.getAllStockPurchases(), HttpStatusCode.valueOf(200));
    }

    @Override
    public ResponseEntity<Purchaseprice> getStockPurchaseById(Long id) {
        return new ResponseEntity<>(purchasePriceService.getStockPurchaseById(id), HttpStatusCode.valueOf(200));
    }

    @Override
    public ResponseEntity<Purchaseprice> updateStockPurchase(Long id, Purchaseprice purchaseprice) {
        purchasePriceService.updateStockPurchase(id, purchaseprice);
        return new ResponseEntity<>(getStockPurchaseById(id).getBody(),HttpStatusCode.valueOf(200));
    }

    @Override
    public ResponseEntity<Void> deleteStockPurchase(Long id) {
        purchasePriceService.deleteStockPurchase(id);
        return new ResponseEntity<>(HttpStatusCode.valueOf(200));
    }*/
}
