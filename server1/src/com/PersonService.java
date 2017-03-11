package com;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface PersonService extends Remote{
	//Gets the set data corresponding to the firstname passed in
	public List<Person> getList(String firstName) throws RemoteException;

}
