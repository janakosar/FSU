package com.fsu.base.federationofsport.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter @Setter @NoArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long id;
	private String username;
	private long salary;
	private int age;

	@JsonIgnore
	private String password;

}