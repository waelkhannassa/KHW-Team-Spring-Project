package com.sip.ams.entities;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


@Entity
public class Book {
	@Id
	@GeneratedValue
	@Column(name = "id_book")
	private int idBook;

	@Column(name = "title")

	private String title;

	@Column(name = "price")

	private double price;
	
	@Column(name = "quantité")

	private double qt;
	
	@Column(name = "coverImage")
	private String coverImage;

	@Column(name = "author")

	private String author;
	
	
	public Book() {

	}


	public Book(int idBook, String title, double price, double qt, String coverImage, String author) {
		super();
		this.idBook = idBook;
		this.title = title;
		this.price = price;
		this.qt = qt;
		this.coverImage = coverImage;
		this.author = author;
	}


	public int getIdBook() {
		return idBook;
	}


	public void setIdBook(int idBook) {
		this.idBook = idBook;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public double getQt() {
		return qt;
	}


	public void setQt(double qt) {
		this.qt = qt;
	}


	public String getCoverImage() {
		return coverImage;
	}


	public void setCoverImage(String coverImage) {
		this.coverImage = coverImage;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	@Override
	public String toString() {
		return "Book [idBook=" + idBook + ", title=" + title + ", price=" + price + ", qt=" + qt + ", coverImage="
				+ coverImage + ", author=" + author + "]";
	}
	
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			 CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name = "id_LCommande")
	private LigneCommande LC;
}
