package com.sip.ams.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class client {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column (name = "id_client")
	private int idClient;
	
	@Column (name="firstName")
	//@NotBlank (message="required")
	private String firstName;
	
	@Column (name="lastName")
	//@NotBlank (message="required")
	private String lastName;
	
	@Column (name="adress")
	//@NotBlank (message="required")
	private String adress;
	
	@Column (name="mail")
	//@NotBlank (message="required")
	private String mail;
	
	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public client() {
		super();
		// TODO Auto-generated constructor stub
	}

	public client(int idClient, String firstName, String lastName, String adress, String mail, int phoneNumber) {
		super();
		this.idClient = idClient;
		this.firstName = firstName;
		this.lastName = lastName;
		this.adress = adress;
		this.mail = mail;
		this.phoneNumber = phoneNumber;
	}

	@Column (name="phoneNumber")
	//@NotBlank (message="required")
	private int phoneNumber;
}
