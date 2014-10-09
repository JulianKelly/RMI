package com.server;

import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Bank extends UnicastRemoteObject implements BankInterface {
	/**
	 * 
	 */
	DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	private static final long serialVersionUID = 1L;
	private static List<Account> accounts=new ArrayList<Account>();																	// accounts
	private static List<Transaction> transactions;

	public Bank() throws RemoteException {
		super();
	}

	public String deposit(int account, int amount) throws RemoteException {
		for (int i = 0; i <accounts.size(); i++) {
			if (accounts.get(i).getAccnum() == account) {
				accounts.get(i).setBalance(amount);
				Date current = new Date();
				String date=df.format(current);
				try {
					current=df.parse(date);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Transaction t= new Transaction(current, amount, "deposit");
				accounts.get(i).setTransaction(t);
				return "Successfully Deposited $"+amount+" to account "+account;

			}

		}
		return "Deposit unsuccessful";

	}

	public String withdraw(int account, int amount) throws RemoteException {
		for (int i = 0; i < accounts.size(); i++)
		{
			if (accounts.get(i).getAccnum() == account) {
				accounts.get(i).setBalance(amount*-1);
				Date current = new Date();
				String date=df.format(current);
				try {
					current=df.parse(date);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Transaction t= new Transaction(current, amount, "withdrawal");
				accounts.get(i).setTransaction(t);
				return "Successfully withdrew $"+amount+" from account "+account;
			}
		}
		
		return "Withdraw unsuccessful";
	}

	public String inquiry(int account) throws RemoteException {
		for (int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).getAccnum() == account) {
				return "Account name: "+accounts.get(i).getName()+", Balance: "+accounts.get(i).getBalance();
			}
		}
		return "Account not found";
	}

	public StatementImpl getStatement(int account, Date from, Date to)
			throws RemoteException {
		for (int i = 0; i < accounts.size(); i++)
		{
			if (accounts.get(i).getAccnum() == account)
			{
				return new StatementImpl(accounts.get(i), from, to);
			}
		}
		return null;
	}

	public static void main(String args[]) throws Exception {
		Account a = new Account(1, 100, "Julian Kelly");
		Account b = new Account(10, 100, "James McCarthy");
		Account c = new Account(100, 1000, "Robert Johnson");
		Account d = new Account(1000, 2000000, "Jack Grier");

		accounts.add(a);
		accounts.add(b);
		accounts.add(c);
		accounts.add(d);
		System.setProperty("java.security.policy","file:/C:/test.policy");
		System.setProperty("java.rmi.server.hostname", "localhost");


		try {
			System.setSecurityManager(new RMISecurityManager()); //secure
			BankInterface bankServer = new Bank();
			Registry registry = LocateRegistry.createRegistry(1099); // RMI Registry created 
			registry.bind("Test RMI", bankServer);
			System.out.println("Instance of Bankserver created");

			Naming.rebind("BankServer", bankServer);
			System.out.println("Name rebind completed");
			System.out.println("Server ready for requests!");
		} catch (Exception exc) {
			System.out.println("Error in main - " + exc.toString());
		}
	}

	public static List<Transaction> getTransactions() {
		return transactions;
	}

}
