package com;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Server {
public static void main(String[] args) {
	try {
		 PersonService personService=new PersonServiceImpl();//realize PersonService interface
		//Register the communication port
		 LocateRegistry.createRegistry(1090);
		//Register the communication path
		 Naming.rebind("rmi://155.246.143.168:1090/PersonService", personService);
		 System.out.println("Server Start!");
	 } catch (Exception e) {
		 e.printStackTrace();
	 }
}
}
