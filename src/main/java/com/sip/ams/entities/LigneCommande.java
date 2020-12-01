package com.sip.ams.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class LigneCommande {
	@Id
	@GeneratedValue
	@Column(name = "id_LCommande")
	private int idLCommande;
	
	@Column(name = "id_book")
	private int idbook;
	
	@Column(name = "id_commande")
	private int idcommande;
	
	
	@Column(name = "prixtotale")
	private double prixtotale;
	
	
	
}
