package model;

import java.util.ArrayList;
import java.util.List;

import exceptions.AgeException;
import exceptions.DayException;

public class Store {

	private List<Person> clients;
	private int entryAttempts;
	
	public Store() {
		clients = new ArrayList<Person>();
	}

	public List<Person> getClients() {
		return clients;
	}

	public void setClients(List<Person> clients) {
		this.clients = clients;
	}

	public int getEntryAttempts() {
		return entryAttempts;
	}

	public void setEntryAttempts(int entryAttempts) {
		this.entryAttempts = entryAttempts;
	}
	
	public boolean add(String type, String id) {
		
		Person p = new Person(type, id);
		if(clients.add(p)) {
			return true;
		}
		return false;
	}
	
	public void validAge(String type) throws AgeException {
		
		if(type.equalsIgnoreCase("TI")) {
			
			throw new AgeException(type);
		} 
	}
	
	public void validDay(String id) throws DayException {

		char[] idChar = id.toCharArray();
		int digit = 0;
		
		for(int i = 0; i < idChar.length; i++) {
			
			if(i == idChar.length - 1) {
				
				String temp = String.valueOf(idChar[i - 1]);
				digit = Integer.parseInt(temp);
			}
		}
		
		if(digit % 2 != 0) {
			
			throw new DayException(id);
		}
	}
}
