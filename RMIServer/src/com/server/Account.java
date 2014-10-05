package com.server;

import java.util.List;

public class Account 
{
	private int accnum;
	private int balance;
	private String name;
	private List<Transaction> transactions;
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
}
