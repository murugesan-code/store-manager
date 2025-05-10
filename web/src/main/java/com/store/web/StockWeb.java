package com.store.web;

import com.store.api.StockApi;
import com.store.api.model.Stock;

import com.store.service.StockService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StockWeb implements StockApi {
    @Autowired
    StockService service;

    @Override
    public ResponseEntity<Void> createStock(Stock stock) {
        service.createStock(stock);
        return new ResponseEntity<Void>(HttpStatusCode.valueOf(200));
    }


    @Override
    public ResponseEntity<Stock> getStockById(Long id) {
        Stock stock = null;
        try {
            stock = service.getStockById(id);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(stock, HttpStatusCode.valueOf(404));
        }
        return new ResponseEntity<>(stock, HttpStatusCode.valueOf(200));
    }

    @Override
    public ResponseEntity<List<Stock>> getAllStocks() {
        List<Stock> stocks = new ArrayList<Stock>();
        try {
            stocks = service.getStocks();
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(stocks, HttpStatusCode.valueOf(404));
        }
        return new ResponseEntity<>(stocks, HttpStatusCode.valueOf(200));
    }

    @Override
    public ResponseEntity<Stock> updateStock(Long id, Stock stock) {
        service.updateStock(id, stock.getName());
        return getStockById(id);
    }

    @Override
    public ResponseEntity<Void> deleteStock(Long id) {
        service.deleteStock(id);
        return new ResponseEntity<Void>(HttpStatusCode.valueOf(200));
    }
}
