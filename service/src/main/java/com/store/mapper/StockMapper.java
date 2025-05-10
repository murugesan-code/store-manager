package com.store.mapper;

import com.store.api.model.Stock;
import com.store.manager.entity.StockEntity;

import java.util.Date;

public class StockMapper {
    public static StockEntity toEntity(Stock dto) {
        if (dto == null) return null;
        StockEntity entity = new StockEntity();
        entity.setName(dto.getName());
        entity.setCreatedDate(new Date());
        entity.setModifiedDate(new Date());
        return entity;
    }

    public static Stock toStockDto(StockEntity stockEntity){
        if(stockEntity== null) return null;
        Stock stockDto = new Stock();
        stockDto.setName(stockEntity.getName());
        return  stockDto;
    }
}
