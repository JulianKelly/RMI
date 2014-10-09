package com.client;

import java.rmi.Naming;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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
					else if(args[0].equals("statement")){
						try 
						{ 
							DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
							System.out.println((banks.getStatement(Integer.parseInt(args[1]), df.parse(args[2]), df.parse(args[3]))).toString());
						} 	
					catch (Exception e) {
						e.printStackTrace();
					}
				
							
						}
					else if(args.length<2||args.length>4){
						System.out.println("Sorry that is an invalid request");
					}
					else{
						System.out.println("Sorry that is an invalid request");


				}}}
				 
				 

