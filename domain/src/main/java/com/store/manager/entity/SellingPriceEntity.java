package com.store.manager.entity;

import java.util.Date;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "selling_price")
public class SellingPriceEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	@ManyToOne
	@JoinColumn(name = "stock_id", nullable = false)
	private StockEntity stock;
	@Column(nullable = false, name = "price_per_unit")
	private float pricePerUnit;
	@Column(nullable = false, name = "created_date")
	private Date createdDate;
	@Column(nullable = false, name = "modified_date")
	private Date modifiedDate;
}
