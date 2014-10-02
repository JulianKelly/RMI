package com.client;

import java.rmi.Naming;

import com.server.BankInterface;

public class ATM {
	public static void main (String args[]) throws Exception 
	{
		BankInterface banks = (BankInterface)Naming.lookup("//localhost/BankServer"); 
				try 
					{ 
						
					} 
					catch (Exception e) {} 
					// get user’s input, and perform the operations
	}
}
