package ui;

import java.util.Scanner;

import exceptions.AgeException;
import exceptions.DayException;
import model.Store;

public class Main {
	
	private static Scanner sc;
	private Store store;
	
	public Main() {
		
		sc = new Scanner(System.in);
		store = new Store();
	}

	public static void main(String[] args) {
		
		Main main = new Main();

		int option = 0;
		
		do {
			
			option = main.mainMenu();
			main.excecuteOption(option);
			
		} while (option != 0);
	}
	
	public int mainMenu() {

//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String option = "";

		System.out.println("\n\n--------MAIN MENU--------\n");

		System.out.println(
				"Select an option:\n" + 
						"(1) Register a person\n" + 
						"(2) Show registration history " + 

				"\n(0) Exit");

		option = sc.nextLine();
		int o = Integer.parseInt(option);
		
		return o;
	}
	
	public void excecuteOption(int option) {

		switch(option) {

		default:
			System.out.println("\n---Invalid Option");
			break;

		case 0:
			System.out.println("\n-----OPERATION ENDED-----\n");
			break;

		case 1:
			registerPerson();
			break;

		case 2:
			entryReports();
			break;
		}
	}
	
	public void registerPerson() {
		
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		store.setEntryAttempts(store.getEntryAttempts() + 1);
		
		System.out.print("\nInput ID type: ");
		String type = sc.nextLine().toUpperCase();
		
		System.out.print("Input ID: ");
		String id = sc.nextLine();
		
		try {
			store.validAge(type);
		} catch (AgeException e) {
//			System.out.println("\n---Client must be over 18 to enter store");
			e.printStackTrace();
		}
		
		try {
			store.validDay(id);
		} catch (DayException e) {
			e.printStackTrace();
		}
		
		if(store.add(type, id)) {
			
			System.out.println("\n--Client registered successfully");
		}
	}
	
	public void entryReports() {

		System.out.println("\n--Total clients: " + store.getClients().size());
		System.out.println("--Entry attempts: " + store.getEntryAttempts());
	}
}
