package com.server;

public class Account 
{
	private int accnum;
	private int balance;
	private String name;
	
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

}
