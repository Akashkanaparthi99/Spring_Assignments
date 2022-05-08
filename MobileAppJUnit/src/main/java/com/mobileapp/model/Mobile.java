package com.mobileapp.model;

public class Mobile {
	private Integer id;
	private String model;
	private String brand;
	private double price;

	public Mobile() {
		super();
	}

	public Mobile(Integer id, String model, String brand, double price) {
		super();
		this.id = id;
		this.model = model;
		this.brand = brand;
		this.price = price;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Mobile [id=" + id + ", model=" + model + ", brand=" + brand + ", price=" + price + "]";
	}
}
