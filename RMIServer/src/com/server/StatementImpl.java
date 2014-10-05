package com.server;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class StatementImpl implements Statement {
	// Create an instance of SimpleDateFormat used for formatting
	// the string representation of date (month/day/year)
	DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
	private static final long serialVersionUID = 1L;
	private List<Account> accounts;// users accounts
	private List<Transaction> currentTransactions;

	public Date getStartDate() {
		return null;
	}

	public Date getEndDate() {
		// TODO Auto-generated method stub
		return null;
	}

	

	public List<Transaction> getTransations(int accnum, Date startDate,
			Date finishDate) {
		String firstDate = df.format(startDate);
		String lastDate = df.format(finishDate);
		int i;
		for (i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).getAccnum() == accnum) {
				for (int j = 0; j < accounts.get(i).getTransaction().size(); j++) {
					if (accounts.get(i).getTransaction().get(j).getDate()
							.toString().equals(firstDate)) {
						currentTransactions.add(accounts.get(i)
								.getTransaction().get(j));
						int k = j + 1;
						do {
							currentTransactions.add(accounts.get(i)
									.getTransaction().get(k));
							k++;
						} while (!accounts.get(i).getTransaction().get(k)
								.getDate().toString().equals(lastDate));
						break;
					}
				}

			}

		}
		return currentTransactions;
	}



	public List<Transaction> getTransations() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getAccountnum() {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getAccoutName() {
		// TODO Auto-generated method stub
		return null;
	}
}
