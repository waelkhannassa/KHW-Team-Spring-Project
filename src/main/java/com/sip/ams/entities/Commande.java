package com.sip.ams.entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
@Entity
public class Commande {
	@Id
	@GeneratedValue
	@Column(name = "id_commande")
	private int idcommande;
	
	@Column(name = "commandeDate")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+5:30")

	private LocalDate commandeDate;

	@Column(name = "price")
	private double price;
	
	@Column(name = "id_book")
	private int idbook;

	
	@Override
	public String toString() {
		return "Commande [idcommande=" + idcommande + ", commandeDate=" + commandeDate + ", price=" + price
				+ ", idbook=" + idbook + ", LC=" + LC + "]";
	}


	public int getIdcommande() {
		return idcommande;
	}


	public void setIdcommande(int idcommande) {
		this.idcommande = idcommande;
	}


	public LocalDate getCommandeDate() {
		return commandeDate;
	}


	public void setCommandeDate(LocalDate commandeDate) {
		this.commandeDate = commandeDate;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public int getIdbook() {
		return idbook;
	}


	public void setIdbook(int idbook) {
		this.idbook = idbook;
	}


	public LigneCommande getLC() {
		return LC;
	}


	public void setLC(LigneCommande lC) {
		LC = lC;
	}


	public Commande() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Commande(int idcommande, LocalDate commandeDate, double price, int idbook, LigneCommande lC) {
		super();
		this.idcommande = idcommande;
		this.commandeDate = commandeDate;
		this.price = price;
		this.idbook = idbook;
		LC = lC;
	}


	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			 CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name = "id_LCommande")
	private LigneCommande LC;
}
