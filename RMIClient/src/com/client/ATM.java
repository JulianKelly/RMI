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
						System.out.println(banks.withdraw(Integer.parseInt(args[1]), Integer.parseInt(args[2])));
						System.out.println("Withdraw Complete");
						System.out.println("New Balance: "+banks.inquiry(Integer.parseInt(args[1])));

					} 	
				catch (Exception e) {
					System.out.println("something cocked up");
				} 
				}
					else if(args[0].equals("deposit")){
						try 
						{ 
							banks.deposit(Integer.parseInt(args[1]), Integer.parseInt(args[2]));
							System.out.println("Deposit Complete");
							System.out.println("New Balance: "+banks.inquiry(Integer.parseInt(args[1])));

						} 	
					catch (Exception e) {
						System.out.println("something cocked up");
					} 
					}
					else if(args[0].equals("inquiry")){
						System.out.println(banks.inquiry(Integer.parseInt(args[1])));
					}


				}
				 
				 }

