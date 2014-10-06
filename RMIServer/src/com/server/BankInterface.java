package com.server;


import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;

public interface BankInterface extends Remote {
public String deposit(int accountnum, int amount) throws RemoteException;
public String withdraw(int accountnum, int amount) throws RemoteException;
public String inquiry(int accountnum) throws RemoteException;
public Statement getStatement(int account, Date from, Date to) throws RemoteException;
}
