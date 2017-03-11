package com;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class PersonServiceImpl extends UnicastRemoteObject implements PersonService{
	
	public PersonServiceImpl() throws RemoteException{
		super();
	}

	@Override
	public List<Person> getList(String firstName) throws RemoteException {
		List<Person> list=new ArrayList<Person>();//Creates a collection
		list.clear();
		try {
			String path=Server.class.getProtectionDomain().getCodeSource().getLocation().getPath();
			BufferedReader reader = new BufferedReader(new FileReader(new File(path+"/com/person.txt")));
			String tempString = null;
			while ((tempString = reader.readLine()) != null) {
				if(tempString!=null && tempString.trim().length()>0){
					String values[]=tempString.split(",");
					Person person=new Person();
					person.setId(Integer.parseInt(values[0]));
					person.setFirstName(values[1]);
					person.setLastName(values[2]);
					list.add(person);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Person> resultList=new ArrayList<Person>();//Creates a collection of returned data
		resultList.clear();
		for(Person person:list){//Traversing the list collection
			if(person.getFirstName().equals(firstName)){//If firstname matches firstname inside person, it will be saved to the returned collection
				resultList.add(person);
			}
		}
		if(resultList.size()==0){
			System.out.println("There is no one with such name in class.");
		}
		return resultList;
	}

	
}
