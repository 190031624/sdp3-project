package com.sdp3.main.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Loan {
	@Id
	@GeneratedValue
	private int id;
	private String providedBy;
	private long amount;
	private double ipa;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProvidedBy() {
		return providedBy;
	}
	public void setProvidedBy(String providedBy) {
		this.providedBy = providedBy;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	public double getIpa() {
		return ipa;
	}
	public void setIpa(double ipa) {
		this.ipa = ipa;
	}
	public Loan(int id, String providedBy, long amount, double ipa) {
		super();
		this.id = id;
		this.providedBy = providedBy;
		this.amount = amount;
		this.ipa = ipa;
	}
	public Loan() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
