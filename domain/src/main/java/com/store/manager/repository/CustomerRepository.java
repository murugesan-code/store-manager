package com.store.manager.repository;

import com.store.manager.entity.CustomerEntity;
import com.store.manager.entity.StockEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

    List<CustomerEntity> findAll();

    Optional<CustomerEntity> findById(Long id);

    CustomerEntity save(CustomerEntity customer);

    @Modifying
    @Query("UPDATE CustomerEntity s SET s.name = :name WHERE s.id = :id")
    int updateCustomerName(@Param("id") Long id, @Param("name") String name);

    @Modifying
    @Query("UPDATE CustomerEntity s SET s.address = :address WHERE s.id = :id")
    int updateCustomerAddress(@Param("id") Long id, @Param("address") String name);

    @Modifying
    @Query("UPDATE CustomerEntity s SET s.phonenumber = :phonenumber WHERE s.id = :id")
    int updateCustomerPhonenumber(@Param("id") Long id, @Param("phonenumber") String name);

    void deleteById(Long id);
}

