package com.store.mapper;

import com.store.api.model.Purchaseprice;
import com.store.api.model.StockPurchase;
import com.store.manager.entity.PurchasePriceEntity;
import com.store.manager.entity.StockPurchaseEntity;
import com.store.manager.entity.StockEntity;
import com.store.manager.entity.SupplierEntity;

import java.util.Date;

public class StockPurchaseMapper {
    public static StockPurchaseEntity toEntity(StockPurchase dto, SupplierEntity supplierEntity, PurchasePriceEntity purchasePriceEntity) {
        if (dto == null) return null;
        StockPurchaseEntity entity = new StockPurchaseEntity();
        entity.setSupplier(supplierEntity);
        entity.setPrice(purchasePriceEntity);
        entity.setQuantity(dto.getQuantity());
        float quantity = dto.getQuantity();
        float pricePerUnit = purchasePriceEntity.getPricePerUnit();
        entity.setTotal_price(quantity * pricePerUnit);
        entity.setPaid_amount(dto.getPaidAmount());
        float balanceAmount = entity.getTotal_price() - dto.getPaidAmount();
        entity.setBalance_amount(balanceAmount);
        entity.setCreatedDate(new Date());
        entity.setModifiedDate(new Date());
        return entity;
    }

    public static Purchaseprice toDto(StockPurchaseEntity entity) {
        if (entity == null) return null;
        Purchaseprice dto = new Purchaseprice();
       // dto.setStockId((long) entity.getStock().getId());
        dto.setPriceperUnit(dto.getPriceperUnit());
        return dto;
    }
}
