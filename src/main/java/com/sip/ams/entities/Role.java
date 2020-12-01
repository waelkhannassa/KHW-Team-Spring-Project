package com.sip.ams.entities;



import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "role")
public class Role {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name = "role_id")
private int id;
@Column(name = "role")
private String role;

public Role() {
	super();
	// TODO Auto-generated constructor stub
}
public Role( String role) {
	
	this.role = role;
}
public int getId() {
return id;
}
public void setId(int id) {
this.id = id;
}
public String getRole() {
return role;
}
public void setRole(String role) {
this.role = role;
}
@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
		CascadeType.REFRESH })
@JoinTable(name = "User", joinColumns = @JoinColumn(name = "roleid"), inverseJoinColumns = @JoinColumn(name = "user_id"))
private List<User> users;
}