package com.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@Table(name="user")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User  {

	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

	private String name;
	@OneToMany(mappedBy = "user",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private List<UserRole> userRoles;
	
	/*@ManyToMany(cascade=CascadeType.REMOVE,fetch=FetchType.EAGER)
	@JoinTable(name="user_role",
	joinColumns={
			@JoinColumn(name="user_id",referencedColumnName="id")
			},
	inverseJoinColumns={
			@JoinColumn(name="role_id",referencedColumnName="id")
			})*/
	/*private List<Role> roles;
	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}*/

	public User() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<UserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(List<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

}