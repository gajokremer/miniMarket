package model;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
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
	
	public boolean add(String type, String id) throws AgeException, DayException {
		
		if(validAge(type) == false) {
			
			throw new AgeException(type);
		}
		
		if(validDay(id) == false) {
			
			throw new DayException(id);
		}
		
		Person p = new Person(type, id);
		if(clients.add(p)) {
			return true;
		}
		return false;
	}
	
	public boolean validAge(String type) {
		
		if(!type.equalsIgnoreCase("TI")) {
			
			return true;
		}
		
		return false;
		
//		if(type.equalsIgnoreCase("TI")) {
//			
//			throw new AgeException(type);
//		} 
	}
	
	public boolean validDay(String id) throws DayException {
		
		boolean valid = false;

		//		SimpleDateFormat date = new SimpleDateFormat();
		Date date = new Date();
		int today = date.getDate();

		char[] idChar = id.toCharArray();
		int digit = 0;

		for(int i = 0; i < idChar.length; i++) {

			if(i == idChar.length - 1) {

				String temp = String.valueOf(idChar[i - 1]);
				digit = Integer.parseInt(temp);
			}
		}

		System.out.println("\nToday: " + today);
		System.out.println("Digit: " + digit);
		
		if(today % 2 == 0) {
			
			System.out.println("even day");

			if(digit % 2 != 0) {

				valid = true;
				
			} else {
				
				valid = false;
			}
			
		} else if(today % 2 != 0) {
			
			System.out.println("odd day");

			if(digit % 2 == 0) {
				
				System.out.println("even digit");
				System.out.println(digit%2);

				valid = true;
				
			} else {
				
				valid = false;
			}
		}
		
		System.out.println("RESULT: " + valid);
		
		return valid;
	}
}
