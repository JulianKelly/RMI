package com.server;

public class Account {
	private int accnum;
	private int balance;
	
	public int getAccnum(){
	return accnum;
	}
	
	public int getBalance(){
		return balance;
	}
	public void setBalance(int i){
		balance+=i;
	}

}
