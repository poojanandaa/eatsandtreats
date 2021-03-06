package net.pn.entbackend.dto;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String code;
	/*@NotBlank(message = "Please enter the item name!")*/
	private String name;
	/*@NotBlank(message = "Please enter the description!")*/
	@JsonIgnore
	private String description;
	@Column(name="unit_price")
	/*@Min(value = 1, message="The Price can not be less than 1!")*/
	private double unitPrice; 
	private int quantity;
	@JsonIgnore
	@Column(name = "is_active")
	private boolean active;
	
	private int purchases;
	private int views;
	@JsonIgnore
	@Column(name = "category_id")
	private int categoryId;	
	
	
	
	@Transient
	private MultipartFile file;
	
	// getters nd setters
	

	//default constructor
	public Item()
	{
		this.code = "ITM" + UUID.randomUUID().toString().substring(26).toUpperCase();
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public int getPurchases() {
		return purchases;
	}

	public void setPurchases(int purchases) {
		this.purchases = purchases;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", code=" + code + ", name=" + name + ", description=" + description + ", unitPrice="
				+ unitPrice + ", quantity=" + quantity + ", active=" + active + ", purchases=" + purchases + ", views="
				+ views + ", categoryId=" + categoryId + ", file=" + file + "]";
	}

	
	
			
	
}
