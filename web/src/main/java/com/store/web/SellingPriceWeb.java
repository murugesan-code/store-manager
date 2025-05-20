package com.store.web;

import com.store.api.SellingpriceApi;
import com.store.api.model.Sellingprice;
import com.store.service.SellingPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SellingPriceWeb implements SellingpriceApi {

    @Autowired
    SellingPriceService sellingPriceService;

    @Override
    public ResponseEntity<Void> createSellingPrice(Sellingprice sellingPrice) {
        sellingPriceService.createSellingPrice(sellingPrice);
        return new ResponseEntity<Void>(HttpStatusCode.valueOf(200));
    }

    @Override
    public ResponseEntity<List<Sellingprice>> getAllSellingPrices() {
        return new ResponseEntity<>(sellingPriceService.getAllSellingPrices(), HttpStatusCode.valueOf(200));
    }

    @Override
    public ResponseEntity<Sellingprice> getSellingPriceById(Long id) {
        return new ResponseEntity<>(sellingPriceService.getSellingPriceById(id), HttpStatusCode.valueOf(200));
    }

    @Override
    public ResponseEntity<Sellingprice> updateSellingPrice(Long id, Sellingprice sellingPrice) {
        sellingPriceService.updateSellingPrice(id, sellingPrice);
        return new ResponseEntity<>(getSellingPriceById(id).getBody(),HttpStatusCode.valueOf(200));
    }

    @Override
    public ResponseEntity<Void> deleteSellingPrice(Long id) {
        sellingPriceService.deleteSellingPrice(id);
        return new ResponseEntity<>(HttpStatusCode.valueOf(200));
    }
}
