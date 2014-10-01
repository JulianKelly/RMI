package com.client;

import java.rmi.Naming;

public class ATM {
	public static void main (String args[]) throws Exception 
	{
		BankServer banks = (BankServer)Naming.lookup("//localhost/BankServer"); 
				try 
					{ 
						
					} 
					catch (Exception e) {} 
					// get user’s input, and perform the operations
	}
}
