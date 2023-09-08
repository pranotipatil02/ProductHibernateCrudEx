package com.example.model;
import javax.persistence.*;
@Entity
@Table(name="products")
public class Product {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)	
private int id;
@Column(name="name")
private String name;
@Column(name="price")
private double price;
public Product(int id, String name, double price) {
	super();
	this.id = id;
	this.name = name;
	this.price = price;
}
public Product() {
	super();
	// TODO Auto-generated constructor stub
}
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
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}


}
