package net.pn.entbackend.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String code;
	private String name;
	private String description;
	@Column(name="unit_price")
	private double unitPrice; 
	private int quantity;
	@Column(name = "is_active")
	private boolean active;
	private int purchases;
	private int views;
	@Column(name = "category_id")
	private int categoryId;	
	
}
