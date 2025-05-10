package com.store.manager.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "stock_purchase")
public class StockPurchase {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	@OneToOne
	@JoinColumn(name = "supplier_id", referencedColumnName = "id" , nullable = false)
	private SupplierEntity supplier;
	
	@OneToOne
	@JoinColumn(name = "purchase_price_id", referencedColumnName = "id" , nullable = false)
	private PurchasePriceEntity price;
	
	@Column(nullable = false, name = "quantity")
	private int quantity;
	
	@Column(nullable = false, name = "total_price")
	private float total_price;
	
	@Column(nullable = false, name = "paid_amount")
	private float paid_amount;
	
	@Column(nullable = false, name = "balance_amount")
	private float balance_amount;
}
