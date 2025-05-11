package com.store.mapper;

import com.store.api.model.Purchaseprice;
import com.store.manager.entity.PurchasePriceEntity;
import com.store.manager.entity.StockEntity;

import java.util.Date;

public class PurchasePriceMapper {
    public static PurchasePriceEntity toEntity(Purchaseprice dto, StockEntity stock) {
        if (dto == null) return null;
        PurchasePriceEntity entity = new PurchasePriceEntity();
        entity.setStock(stock);
        entity.setPricePerUnit(dto.getPriceperUnit());
        entity.setCreatedDate(new Date());
        entity.setModifiedDate(new Date());
        return entity;
    }

    public static Purchaseprice toDto(PurchasePriceEntity entity, StockEntity stock) {
        if (entity == null) return null;
        Purchaseprice dto = new Purchaseprice();
        dto.setStockId((long) entity.getStock().getId());
        dto.setPriceperUnit(dto.getPriceperUnit());
        return dto;
    }
}
