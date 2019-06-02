package com.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the user_role database table.
 * 
 */
@Entity
@Table(name="user_role")
@NamedQuery(name="UserRole.findAll", query="SELECT u FROM UserRole u")
public class UserRole  {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private UserRolePK id;
	@ManyToOne
	@JoinColumn(name="user_id",insertable = false, updatable = false)
	//@MapsId("user_id")
	private User user;
	@ManyToOne
	@JoinColumn(name="role_id",insertable = false, updatable = false)
	//@MapsId("role_id")
	private Role role;
	
	

	public UserRole() {
	}



	public UserRolePK getId() {
		return id;
	}



	public void setId(UserRolePK id) {
		this.id = id;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public Role getRole() {
		return role;
	}



	public void setRole(Role role) {
		this.role = role;
	}


}