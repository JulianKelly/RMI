package com.server;

import java.util.Date;

public class Transaction {
	private Date dateOfTransaction;
	private int balance;
	private String transactionType;

	public Transaction(Date dateOfTransaction, int balance,
			String transactionType) {
		this.dateOfTransaction = dateOfTransaction;
		this.transactionType = transactionType;
		this.balance = balance;
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

	public int getBalance() {
		return balance;
	}
}
