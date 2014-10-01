package com.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;
import java.util.List;

import com.interf.BankInterface;
import com.interf.Statement;

public class Bank extends UnicastRemoteObject implements BankInterface {
private List<Account> accounts; // users accounts
public Bank() throws RemoteException
{
}
public void deposit(int account, int amount) throws RemoteException {
	for(int i=0; i<=accounts.size(); i++){
		if(accounts.get(i).getAccnum()==account){
		   accounts.get(i).setBalance(amount);	
		}
	}
}
public void withdraw(int account, int amount) throws RemoteException {
	for(int i=0; i<=accounts.size(); i++){
		if(accounts.get(i).getAccnum()==account){
		   accounts.get(i).setBalance(amount*-1);	
		}
	}
}
public int inquiry(int account) throws RemoteException {
	int bal=0;
	for(int i=0; i<=accounts.size(); i++){
		if(accounts.get(i).getAccnum()==account){
		   bal= accounts.get(i).getBalance();	
		}
	}
	return bal;
}
public Statement getStatement(Date from, Date to) throws RemoteException {
return new BankStatement();
}
public static void main(String args[]) throws Exception {
// initialise Bank server - see sample code in the notes for details
}
}
