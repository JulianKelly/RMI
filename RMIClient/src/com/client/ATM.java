package com.client;

import java.rmi.Naming;

import com.server.BankInterface;

public class ATM {
	public static void main (String args[]) throws Exception 
	{
		
		BankInterface banks = (BankInterface)Naming.lookup("//localhost/BankServer");
 
				if(args[0].equals("withdraw")){
					try 
					{ 
						banks.inquiry(Integer.parseInt(args[1]));
						banks.deposit(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
						banks.inquiry(Integer.parseInt(args[1]));

					} 	
				catch (Exception e) {
					System.out.println("FFFFFFFFFFFF");
				} 
				}
					else{
					System.out.println(args[0]);
					System.out.println("poo");
					}

				}
				 
				 }

