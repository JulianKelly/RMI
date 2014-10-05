package com.server;


import java.util.Date;
import java.util.List;


public class StatementImpl implements Statement {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Account account;// users accounts
	private List<Transaction> transactions;
	public int getAccountnum() {
		return account.getAccnum();
	}

	public Date getStartDate() {
		// TODO Auto-generated method stub
		return null;
	}

	public Date getEndDate() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getAccoutName() {
		// TODO Auto-generated method stub
		return account.getName();
	}

	public List<Transaction> getTransations() {
		transactions = Bank.getTransactions();
		return transactions;
	}

}
