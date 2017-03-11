package com;

import java.rmi.Naming;
import java.util.List;

public class Client {
public static void main(String[] args) {
	try{
		//Call the remote object, RMI path and interface must be consistent with the server configuration
		 PersonService personService=(PersonService)Naming.lookup("rmi://155.246.166.104:6600/PersonService");
		 List<Person> personList=personService.getList((args!=null && args.length>0)?args[0]:"jack");
		 if(personList.size()==0){
			System.out.println("There is no one with such name in class.");
		 }
		 for(Person person:personList){
			 System.out.println("ID:"+person.getId()+" first_name:"+person.getFirstName()+" last_name:"+person.getLastName());
		 }
	 }catch(Exception ex){
	 ex.printStackTrace();
	 }
}
}
