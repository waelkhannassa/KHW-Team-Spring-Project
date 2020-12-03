package com.sip.ams.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
//@Table (name = "Commande")
public class Commande {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_Commande")
	private int idCommande;

	@Column(name = "CommandeDate")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+5:30")

	private LocalDate CommandeDate;

	@Column(name = "price")
	private double price;

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Commande() {

	}


	public Commande(LocalDate CommandeDate, double price) {
		super();
		this.CommandeDate = CommandeDate;
		this.price = price;
	}

	public Commande(LocalDate CommandeDate) {

		this.CommandeDate = CommandeDate;
	}

	public int getIdCommande() {
		return idCommande;
	}

	public void setIdCommande(int idCommande) {
		this.idCommande = idCommande;
	}

	public LocalDate getCommandeDate() {
		return CommandeDate;
	}

	public void setCommandeDate(LocalDate CommandeDate) {
		this.CommandeDate = CommandeDate;
	}

	@Override
	public String toString() {
		return "Commande [idCommande=" + idCommande + ", CommandeDate=" + CommandeDate + "]";
	}

	/*@OneToMany(mappedBy = "co", fetch = FetchType.LAZY)
	private List<CommandeDetails> lignecom;*/

	// select from id_book from Commandedetail where id_Commande=?1
	//

	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			 CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name = "id_client")
	private User client_c;

	/*public List<CommandeDetails> getLignecom() {
		return lignecom;
	}

	public void setLignecom(List<CommandeDetails> lignecom) {
		this.lignecom = lignecom;
	}
*/
	public User getUser() {
		return  client_c;
	}

	public void setUser(User client) {
		this.client_c = client;
	}
	
	
	
	@ManyToMany(fetch=FetchType.LAZY,
			cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			 CascadeType.DETACH, CascadeType.REFRESH})
	@JoinTable(
			name="Commande_details",
			joinColumns=@JoinColumn(name="id_Commande"),
			inverseJoinColumns=@JoinColumn(name="id_book")
			)	
	private List<Book> books;

	public void addmybooks(Book book) {
		if (books == null) {
			books = new ArrayList<>();
		}

		books.add(book);
	}
	public List<Book> getmybooks(){
		return books;
	}
	
	

/*public void addCommandedetails(CommandeDetails Commandedetail) {
		this.lignecom.add(Commandedetail);
	}
*/
}
