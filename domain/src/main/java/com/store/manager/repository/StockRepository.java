package com.store.manager.repository;

import com.store.manager.entity.StockEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StockRepository extends JpaRepository<StockEntity, Long> {

    List<StockEntity> findAll();

    Optional<StockEntity> findById(Long id);

    StockEntity save(StockEntity stock);

    @Modifying
    @Query("UPDATE StockEntity s SET s.name = :name WHERE s.id = :id")
    int updateStockName(@Param("id") Long id, @Param("name") String name);

    void deleteById(Long id);
}

