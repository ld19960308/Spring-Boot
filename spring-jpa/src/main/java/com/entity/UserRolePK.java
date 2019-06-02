package com.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class UserRolePK implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name="role_id")
	private String roleId;
	@Column(name="user_id")
	private String userId;
	public String getRoleId() {
		return roleId;
	}
	public UserRolePK() {
		super();
	}
	public UserRolePK(String roleId, String userId) {
		super();
		this.roleId = roleId;
		this.userId = userId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

}
