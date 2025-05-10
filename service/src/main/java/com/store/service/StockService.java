package com.store.service;

import com.store.api.model.Stock;
import com.store.manager.entity.StockEntity;
import com.store.manager.repository.StockRepository;
import com.store.mapper.StockMapper;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StockService {
    @Autowired
    private StockRepository stockRepository;

    public void createStock(Stock stock) {
        stockRepository.save(StockMapper.toEntity(stock));
    }

    public Stock getStockById(Long id) {
        Optional<StockEntity> stock = stockRepository.findById(id);
        return stock
                .map(StockMapper::toStockDto)
                .orElseThrow(() -> new EntityNotFoundException("Stock not found"));
    }

    public List<Stock> getStocks() {
        List<StockEntity> stocks = stockRepository.findAll();
        return stocks.stream()
                .map(StockMapper::toStockDto).collect(Collectors.toList());
    }

    @Transactional
    public void updateStock(Long id, String name){
        int updated = stockRepository.updateStockName(id,name);
        if (updated == 0) {
            throw new EntityNotFoundException("Stock not found with ID: " + id);
        }
    }

    public void deleteStock(Long id) {
        if (!stockRepository.existsById(id)) {
            throw new EntityNotFoundException("Stock with id " + id + " not found");
        }
        stockRepository.deleteById(id);
    }
}
