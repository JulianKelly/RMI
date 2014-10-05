package com.server;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class StatementImpl implements Statement {

	private Date StartDate;
	private Date EndDate;
	
	// Create an instance of SimpleDateFormat used for formatting 
	// the string representation of date (month/day/year)
	DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");       
	 // number of days to add
	
	String reportDate1 = df.format(StartDate);
	String reportDate2 = df.format(EndDate);
	private static final long serialVersionUID = 1L;
	private Account account;// users accounts
	private List<Transaction> transactions;
	private List<Transaction> neededforStatement;
	
	public int getAccountnum() {
		return account.getAccnum();
	}



	public Date getStartDate() {
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

	public List<Transaction> getTransations() 
	{
		int i;
		for(i = 0; i < transactions.size(); i++)
		{
		if(account.getAccnum() == transactions.get(i).getAccNum())
		{
			if(transactions.get(i).getDate().toString() == reportDate2)
			{
				return null;
			}
			if(transactions.get(i).getDate().toString() == reportDate1)
			{
			while(transactions.get(i).getDate().toString() != reportDate2)
			
				transactions = Bank.getTransactions();
				Transaction a = new Transaction(transactions.get(i).getAccNum(), transactions.get(i).getDate(),transactions.get(i).returnBalance(), "Withdrawal");
				neededforStatement.add(a);
				i++;
			}
	
		}
		
		}
		return neededforStatement;
	}
}
