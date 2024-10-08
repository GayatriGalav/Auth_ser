package com.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name="users")
public class User {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long user_Id;
	@Column(nullable=false)
	private String user_Name;
	@Column(nullable=false,unique = true)
	private String email;
	@Column(nullable=false)
	private String password;
	@Column
	private String mobileNo;
	@Lob
	private String address;
	@Column(name="user_role")
	private String role;

}
