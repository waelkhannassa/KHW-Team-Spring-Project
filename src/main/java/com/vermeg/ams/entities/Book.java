package com.vermeg.ams.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private long id;
	// @NotBlank(message = "Title is mandatory")
	@Column(name = "title")
	private String title;
	// @NotBlank(message = "Author is mandatory")
	@Column(name = "author")
	private String author;
	// @NotBlank(message = "Price is mandatory")
	@Column(name = "price")
	private Double price;
	// @NotBlank(message = "quantity is mandatory")
	@Column(name = "quantity")
	private int quantity;
	// @NotBlank(message = "Date is mandatory")
	@Column(name = "date")
	private String date;
	// @NotBlank(message = "Image is mandatory")
	@Column(name = "picture")
	private String picture;
	

	public Book(long id, String title, String author, Double price, int quantity, String date, String picture) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.price = price;
		this.quantity = quantity;
		this.date = date;
		this.picture = picture;
	
	}

	public Book() {
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}



	/*private List<LigneCommand> ligneCommands;

	@OneToMany(mappedBy = "book")
	public List<LigneCommand> getLigneCommands() {
		return ligneCommands;
	}

	public void setLigneCommands(List<LigneCommand> ligneCommands) {
		this.ligneCommands = ligneCommands;
	}*/
}