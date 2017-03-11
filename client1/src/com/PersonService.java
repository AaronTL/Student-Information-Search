package com;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface PersonService extends Remote{
	
	public List<Person> getList(String firstName) throws RemoteException;

}
