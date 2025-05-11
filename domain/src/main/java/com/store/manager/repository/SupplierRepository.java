
package com.store.manager.repository;

import com.store.manager.entity.SupplierEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SupplierRepository extends JpaRepository<SupplierEntity, Long> {

    List<SupplierEntity> findAll();

    Optional<SupplierEntity> findById(Long id);

    SupplierEntity save(SupplierEntity supplier);

    @Modifying
    @Query("UPDATE SupplierEntity s SET s.name = :name WHERE s.id = :id")
    int updateSupplierName(@Param("id") Long id, @Param("name") String name);

   @Modifying
    @Query("UPDATE SupplierEntity s SET s.address = :address WHERE s.id = :id")
    int updateSupplierAddress(@Param("id") Long id, @Param("address") String name);

    @Modifying
    @Query("UPDATE SupplierEntity s SET s.phonenumber = :phonenumber WHERE s.id = :id")
    int updateSupplierPhonenumber(@Param("id") Long id, @Param("phonenumber") String name);

    void deleteById(Long id);
}

