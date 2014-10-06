package com.server;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		String firstDate = df.format(startDate);
		String lastDate = df.format(finishDate);
		for (int j = 0; j < account.getTransaction().size(); j++) 
		{
			if(account.getTransaction().get(j).getDateOfTransaction().toString().equals(firstDate)&&account.getTransaction().get(j).getDateOfTransaction().toString().equals(lastDate)){
				transactions.add(account.getTransaction().get(j));
				break;
			}
			if (account.getTransaction().get(j).getDateOfTransaction().toString().equals(firstDate)) 
			{
				transactions.add(account.getTransaction().get(j));
				int k = j + 1;
				do 
				{
					transactions.add(account.getTransaction().get(k));
					k++;
				} while (!account.getTransaction().get(k)
						.getDateOfTransaction().toString().equals(lastDate));
				break;
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
