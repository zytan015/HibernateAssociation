package org.dxc.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;

@Entity
public class Txn {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private Date date;
	private double total;
	
	@OneToOne(mappedBy="txn")
	@Cascade(value=org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	private Customers customers;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Customers getCustomers() {
		return customers;
	}

	public void setCustomers(Customers customers) {
		this.customers = customers;
	}
	
//	@Override
//	public String toString(){
//		return id+", "+total+", "+customer.getName()+", "+customer.getEmail()+", "+customer.getAddress();
//	}
}
