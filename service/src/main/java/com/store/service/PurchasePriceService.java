package com.store.service;

import com.store.api.model.Purchaseprice;
import com.store.manager.entity.PurchasePriceEntity;
import com.store.manager.entity.StockEntity;
import com.store.manager.repository.PurchasePriceRepository;
import com.store.manager.repository.StockRepository;
import com.store.mapper.PurchasePriceMapper;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PurchasePriceService {
    @Autowired
    private PurchasePriceRepository purchasePriceRepository;
    @Autowired
    private StockRepository stockRepository;

    public void createPurchasePrice(Purchaseprice purchasePrice) {
        Optional<StockEntity> stockEntity = stockRepository.findById(purchasePrice.getStockId());
        if (stockEntity.isPresent()) ;
        purchasePriceRepository.save(PurchasePriceMapper.toEntity(purchasePrice, stockEntity.get()));
    }


    public Purchaseprice getPurchasePriceById(Long id) {
        Optional<PurchasePriceEntity> customer = purchasePriceRepository.findById(id);
        return customer
                .map(PurchasePriceMapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException("PurchasePrice not found"));
    }

    public List<Purchaseprice> getAllPurchasePrices() {
        List<PurchasePriceEntity> purchasePrices = purchasePriceRepository.findAll();
        return purchasePrices.stream()
                .map(PurchasePriceMapper::toDto).collect(Collectors.toList());
    }

    @Transactional
    public void updatePurchasePrice(Long purchasePriceId, Purchaseprice purchasePrice) {
        Purchaseprice oldPurchasePrice = getPurchasePriceById(purchasePriceId);
        if (oldPurchasePrice.getPriceperUnit() != purchasePrice.getPriceperUnit()) {
            purchasePriceRepository.updatePurchasePrice(purchasePriceId, purchasePrice.getPriceperUnit());
        }
    }

    public void deletePurchasePrice(Long id) {
        if (!purchasePriceRepository.existsById(id)) {
            throw new EntityNotFoundException("PurchasePrice with id " + id + " not found");
        }
        purchasePriceRepository.deleteById(id);
    }

}

