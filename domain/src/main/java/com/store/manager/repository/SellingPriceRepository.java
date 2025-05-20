package com.store.manager.repository;

import com.store.manager.entity.PurchasePriceEntity;
import com.store.manager.entity.SellingPriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SellingPriceRepository extends JpaRepository<SellingPriceEntity, Long> {

    List<SellingPriceEntity> findAll();

    Optional<SellingPriceEntity> findById(Long id);

    SellingPriceEntity save(SellingPriceEntity sellingPriceEntity);

    @Modifying
    @Query("UPDATE SellingPriceEntity s SET s.pricePerUnit = :pricePerUnit WHERE s.id = :id")
    int updateSellingPrice(@Param("id") Long id, @Param("pricePerUnit") float pricePerUnit);

    void deleteById(Long id);
}

