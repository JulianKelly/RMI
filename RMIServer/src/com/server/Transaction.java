package com.server;

import java.util.Date;

public class Transaction 
{
	private Date DateOfTransaction;
	private int balance;
	private String TransType;
	
	public void SetTransType(String Trans)
	{
		TransType = Trans;
	}
	public String getTransType()
	{
		return TransType;
	}
	
	public void setDate()
	{
		Date currentDate = new Date();
		DateOfTransaction = currentDate;
	}
}
