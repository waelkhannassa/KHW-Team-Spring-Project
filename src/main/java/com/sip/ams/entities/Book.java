package com.sip.ams.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;


@Entity
public class Book {
	@Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 private int id;
	 @NotBlank(message = "title is mandatory")
	@Column(name = "title")
	 private String title;

	 @NotBlank(message = "price is mandatory")
	 @Column(name = "price")
	 private float price;
	 @NotBlank(message = "author is mandatory")
	 @Column(name = "author")
	 private String author;
	 @NotBlank(message = "releaseDate is mandatory")
	 @Column(name = "releaseDate")
	 private Date releaseDate;
	 
	 public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public Book() {
	
		// TODO Auto-generated constructor stub
	}

	public Book(int id, String title, float price, String author, Date releaseDate, String picture) {
	
		this.id = id;
		this.title = title;
		this.price = price;
		this.author = author;
		this.releaseDate = releaseDate;
		this.picture = picture;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", price=" + price + ", author=" + author + ", releaseDate="
				+ releaseDate + ", picture=" + picture + "]";
	}

	@Column(name = "picture")
	 private String picture;
}
