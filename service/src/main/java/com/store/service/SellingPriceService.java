package com.store.service;

import com.store.api.model.Sellingprice;
import com.store.manager.entity.PurchasePriceEntity;
import com.store.manager.entity.SellingPriceEntity;
import com.store.manager.entity.StockEntity;
import com.store.manager.repository.SellingPriceRepository;
import com.store.manager.repository.StockRepository;
import com.store.mapper.PurchasePriceMapper;
import com.store.mapper.SellingPriceMapper;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SellingPriceService {
    @Autowired
    private SellingPriceRepository sellingPriceRepository;
    @Autowired
    private StockRepository stockRepository;

    public void createSellingPrice(Sellingprice sellingPrice) {
        Optional<StockEntity> stockEntity = stockRepository.findById(sellingPrice.getStockId());
        if (stockEntity.isPresent()) ;
        sellingPriceRepository.save(SellingPriceMapper.toEntity(sellingPrice, stockEntity.get()));
    }


    public Sellingprice getSellingPriceById(Long id) {
        Optional<SellingPriceEntity> sellingPrice = sellingPriceRepository.findById(id);
        return sellingPrice
                .map(SellingPriceMapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException("PurchasePrice not found"));
    }

    public List<Sellingprice> getAllSellingPrices() {
        List<SellingPriceEntity> sellingPrices = sellingPriceRepository.findAll();
        return sellingPrices.stream()
                .map(SellingPriceMapper::toDto).collect(Collectors.toList());
    }

    @Transactional
    public void updateSellingPrice(Long sellingPriceId, Sellingprice sellingPrice) {
        Sellingprice oldPurchasePrice = getSellingPriceById(sellingPriceId);
        if (oldPurchasePrice.getPriceperUnit() != sellingPrice.getPriceperUnit()) {
            sellingPriceRepository.updateSellingPrice(sellingPriceId, sellingPrice.getPriceperUnit());
        }
    }

    public void deleteSellingPrice(Long id) {
        if (!sellingPriceRepository.existsById(id)) {
            throw new EntityNotFoundException("Sellingprice with id " + id + " not found");
        }
        sellingPriceRepository.deleteById(id);
    }

}

