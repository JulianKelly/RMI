package com.server;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Account implements Serializable
{
	private int accnum;
	private int balance;
	private String name;
	private List<Transaction> transactions= new ArrayList<Transaction>();
	public Account(int AccountN, int bal, String Nme)
	{
		accnum = AccountN;
		balance = bal;
		name = Nme;
	}
	public int getAccnum()
	{
		return accnum;
	}
	
	public int getBalance()
	{
		return balance;
	}
	public void setBalance(int i)
	{
		balance+=i;
	}
	public String getName()
	{
		return name;
	}
	public List<Transaction> getTransaction()
	{
		return transactions;
	}
	public void setTransaction(Transaction t){
		transactions.add(t);
		
	}
}
