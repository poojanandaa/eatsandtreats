package net.pn.entbackend.dto;

public class Category {

	 private int id;
	 private String name;
	 private boolean active = true;
	 
	 
	 
	// getters and setters 
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	} 
	 
	 
}
