package com.server;


import java.util.Date;

public class Transaction 
{
	private Date DateOfTransaction;
	private int balance;
	private String TransType;
	private int accnum;
	
	public Transaction(int accN, Date TDate, int TBalance, String TType)
	{
		accnum = accN;
		DateOfTransaction = TDate;
		balance = TBalance;
		TransType = TType;
	}
	public int getAccNum()
	{
		return accnum;
	}

	public String getTransType()
	{
		return TransType;
	}
	public Date getDate()
	{
		return DateOfTransaction;
	}
	public int returnBalance()
	{
		return balance;
	}
}
