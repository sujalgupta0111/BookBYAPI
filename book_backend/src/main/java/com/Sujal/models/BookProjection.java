package com.Sujal.models;

//JPA Projection or a DTO (Data Transfer Object) Class
public class BookProjection {
	private String name;
	private int price;
	private String aname;
	private String pname;

	public BookProjection(String name, int price, String aname, String pname) {
		this.name = name;
		this.price = price;
		this.aname = aname;
		this.pname = pname;
	}

	// Getters
	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public String getAname() {
		return aname;
	}

	public String getPname() {
		return pname;
	}
}
