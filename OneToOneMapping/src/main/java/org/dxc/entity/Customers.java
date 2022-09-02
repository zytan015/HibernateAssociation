package org.dxc.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
public class Customers {
	@Id
	@GeneratedValue(generator="gen")
	@GenericGenerator(name="gen", strategy="foreign", parameters={@Parameter(name="property", value="txn")})
	private long id;
	private String name;
	private String email;
	private String address;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private Txn txn;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Txn getTxn() {
		return txn;
	}
	public void setTransaction(Txn txn) {
		this.txn = txn;
	}
	
	
}
