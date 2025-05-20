package com.store.mapper;

import com.store.api.model.Sellingprice;
import com.store.manager.entity.SellingPriceEntity;
import com.store.manager.entity.StockEntity;

import java.util.Date;

public class SellingPriceMapper {
    public static SellingPriceEntity toEntity(Sellingprice dto, StockEntity stock) {
        if (dto == null) return null;
        SellingPriceEntity entity = new SellingPriceEntity();
        entity.setStock(stock);
        entity.setPricePerUnit(dto.getPriceperUnit());
        entity.setCreatedDate(new Date());
        entity.setModifiedDate(new Date());
        return entity;
    }

    public static Sellingprice toDto(SellingPriceEntity entity) {
        if (entity == null) return null;
        Sellingprice dto = new Sellingprice();
        dto.setStockId((long) entity.getStock().getId());
        dto.setPriceperUnit(dto.getPriceperUnit());
        return dto;
    }
}
