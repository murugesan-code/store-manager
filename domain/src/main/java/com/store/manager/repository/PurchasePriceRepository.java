package com.store.manager.repository;

import com.store.manager.entity.CustomerEntity;
import com.store.manager.entity.PurchasePriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PurchasePriceRepository extends JpaRepository<PurchasePriceEntity, Long> {

    List<PurchasePriceEntity> findAll();

    Optional<PurchasePriceEntity> findById(Long id);

    PurchasePriceEntity save(PurchasePriceEntity purchasePriceEntity);

    @Modifying
    @Query("UPDATE PurchasePriceEntity s SET s.pricePerUnit = :pricePerUnit WHERE s.id = :id")
    int updatePurchasePrice(@Param("id") Long id, @Param("pricePerUnit") float pricePerUnit);

    void deleteById(Long id);
}

