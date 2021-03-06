package com.interf;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;

public interface BankInterface extends Remote {
public void deposit(int accountnum, int amount) throws RemoteException;
public void withdraw(int accountnum, int amount) throws RemoteException;
public int inquiry(int accountnum) throws RemoteException;
public Statement getStatement(Date from, Date to) throws RemoteException;
}
