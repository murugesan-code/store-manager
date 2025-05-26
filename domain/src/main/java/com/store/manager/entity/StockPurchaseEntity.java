package com.store.manager.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "stock_purchase")
public class StockPurchaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @OneToOne
    @JoinColumn(name = "supplier_id", referencedColumnName = "id", nullable = false)
    private SupplierEntity supplier;

    @OneToOne
    @JoinColumn(name = "purchase_price_id", referencedColumnName = "id", nullable = false)
    private PurchasePriceEntity price;



    @Column(nullable = false, name = "quantity")
    private float quantity;

    @Column(nullable = false, name = "total_price")
    private float total_price;

    @Column(nullable = false, name = "paid_amount")
    private float paid_amount;

    @Column(nullable = false, name = "balance_amount")
    private float balance_amount;
    @Column(nullable = false, name = "created_date")
    private Date createdDate;
    @Column(nullable = false, name = "modified_date")
    private Date modifiedDate;

}
