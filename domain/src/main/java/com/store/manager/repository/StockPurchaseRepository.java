package com.store.manager.repository;

import com.store.manager.entity.StockPurchaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StockPurchaseRepository extends JpaRepository<StockPurchaseEntity, Long > {

    List<StockPurchaseEntity> findAll();

    Optional<StockPurchaseEntity> findById(Long id);

    StockPurchaseEntity save(StockPurchaseEntity stockPurchaseEntity);

   /* @Modifying
    @Query("UPDATE StockPurchase s SET s.pricePerUnit = :pricePerUnit WHERE s.id = :id")
    int updateStockPurchase(@Param("id") Long id, @Param("pricePerUnit") float pricePerUnit);
*/
    void deleteById(Long id);
}

