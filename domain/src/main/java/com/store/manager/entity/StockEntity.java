package com.store.manager.entity;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "stock")
public class StockEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false, name = "created_date")
	private Date createdDate;
	@Column(nullable = false, name = "modified_date")
	private Date modifiedDate;
	@OneToMany(mappedBy = "stock", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<PurchasePriceEntity> purchasePrices;
	@OneToMany(mappedBy = "stock", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<SellingPriceEntity> sellingPrices;
}
