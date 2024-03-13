package com.JT_project.GradingSystem.Models;


import jakarta.persistence.*;
@Entity
@Table(name="roles")
public class roles {
       @Id
       @OneToOne(cascade=CascadeType.ALL)
       @JoinColumn(name="user_id")
	   private User user;
       
       @Column(name="role")
       private String role;
       
       
    public User getUser() {
		return user;
	}
	public void setUser_id(User user) {
		this.user=user;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
       
       
}
