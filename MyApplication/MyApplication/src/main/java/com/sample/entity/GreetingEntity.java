package com.sample.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="greeting")
public class GreetingEntity {

	@Id
	@Column(name="id", unique=true)
	private int id;
	
	@Column(name="greeting")
	private String greeting;
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getGreeting() {
		return this.greeting;
	}
	
	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}
}
