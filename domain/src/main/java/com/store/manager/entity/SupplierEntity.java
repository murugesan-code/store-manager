package com.store.manager.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@Entity(name="supplier")
public class SupplierEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String phonenumber;
	@Column(nullable = false)
	private String address;
	@Column(nullable = false,name = "created_date")
  	private Date createdDate;
	@Column(nullable = false,name = "modified_date")
	private Date modifiedDate;
}
