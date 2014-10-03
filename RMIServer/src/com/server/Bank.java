package com.server;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Bank extends UnicastRemoteObject implements BankInterface {
/**
	 * 
	 */
private static final long serialVersionUID = 1L;
private static List<Account> accounts =new ArrayList<Account>();// users accounts
private static List<Transaction> transactions;
public Bank() throws RemoteException
{
	super(); 
}
public void deposit(int account, int amount) throws RemoteException {
	for(int i=0; i<=accounts.size(); i++){
		if(accounts.get(i).getAccnum()==account){
		   accounts.get(i).setBalance(amount);	
		   Date current  = new Date();
		   getTransactions().add(new Transaction(accounts.get(i).getAccnum(),current, accounts.get(i).getBalance(),"Deposit"));
		}
	
	}
	System.out.println("ma nigguh");
}
public void withdraw(int account, int amount) throws RemoteException {
	for(int i=0; i<accounts.size(); i++){
		if(accounts.get(i).getAccnum()==account){
		   accounts.get(i).setBalance(amount*-1);
		   Date current  = new Date();
		   getTransactions().add(new Transaction(accounts.get(i).getAccnum(),current, accounts.get(i).getBalance(),"Withdrawal"));
		}
	}
}
public void inquiry(int account) throws RemoteException {
	int bal=0;
	for(int i=0; i<accounts.size(); i++){
		if(accounts.get(i).getAccnum()==account){
		   bal= accounts.get(i).getBalance();	
		}
	}
	System.out.println(bal);
}
public StatementImpl getStatement(Date from, Date to) throws RemoteException {
return new StatementImpl();
}
public static void main(String args[]) throws Exception {
	Account a = new Account(1,100,"Julian");
	Account b = new Account(10,100,"James");
	accounts= new ArrayList<Account>();
	accounts.add(a);
	accounts.add(b);
// initialise Bank server - see sample code in the notes for details
	try 
	{  
		// First reset our Security manager 
		//System.setSecurityManager(new RMISecurityManager()); //secure
		//System.out.println("Security manager set"); 

		// Create an instance of the local object 
		BankInterface bankServer = new Bank(); 
		Registry registry = LocateRegistry.createRegistry(1099);
		registry.bind("Test RMI", bankServer);
		System.out.println("Instance of Bankserver created"); 
	
		Naming.rebind("BankServer", bankServer); 
		System.out.println("Name rebind completed"); 
		System.out.println("Server ready for requests!"); 
	} 
	catch(Exception exc) 
	{ 
		System.out.println("Error in main - " + exc.toString()); 
	} 
}
public static List<Transaction> getTransactions() {
	return transactions;
}
}
