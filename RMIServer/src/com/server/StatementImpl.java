package com.server;

import java.util.Date;
import java.util.List;

@SuppressWarnings("serial")
public class StatementImpl implements Statement {
	private Account account;// users accounts
	private List<Transaction> transactions;
	private Date startDate;
	private Date endDate;

	public Date getStartDate() {
		return startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public StatementImpl(Account account, Date startDate, Date finishDate) 
	{
		for (int j = 0; j < account.getTransaction().size(); j++) 
		{
			if(account.getTransaction().get(j).getDateOfTransaction().compareTo(startDate)>=0&&account.getTransaction().get(j).getDateOfTransaction().compareTo(finishDate)<=0){
				transactions.add(account.getTransaction().get(j));
				
			}
		}
		this.account = account;
		this.startDate = startDate;
		this.endDate = finishDate;
	}

	public List<Transaction> getTransations() {
		return transactions;
	}

	public int getAccountnum() {
		return account.getAccnum();
	}

	public String getAccoutName() {
		return account.getName();
	}
}
