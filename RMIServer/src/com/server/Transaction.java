package com.server;

import java.util.Date;

public class Transaction {
	private Date dateOfTransaction;
	private int amount;
	private String transactionType;

	public Transaction(Date dateOfTransaction, int amount, String transactionType) {
		this.dateOfTransaction = dateOfTransaction;
		this.transactionType = transactionType;
		this.amount = amount;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public Date getDateOfTransaction() {
		return dateOfTransaction;
	}

	public void setDateOfTransaction(Date dateOfTransaction) {
		this.dateOfTransaction = dateOfTransaction;
	}

	public int getAmount() {
		return amount;
	}
}
