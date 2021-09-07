package com.gujiedmc.tx.byteTcc.provider.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_account_one")
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "acct_id", nullable = false)
	private String identifier;
	@Column(name = "amount", nullable = false)
	private double amount;
	@Column(name = "frozen", nullable = false)
	private double frozen;

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public double getFrozen() {
		return frozen;
	}

	public void setFrozen(double frozen) {
		this.frozen = frozen;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

}
