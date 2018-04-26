package edu.handong.csee.java.example;

import java.util.Arrays;
import java.util.Scanner;

public class SalesReporter {
	
	private double highestSales;
	private double averageSales;
	private Salesman[] team; 
	private int numOfSalesman;

	public static void main(String[] args) {
		
		SalesReporter myReporter = new SalesReporter();
		myReporter.run();
	}
	
	public void run() {
		getData();
		cacluateAverageSales();
		calculateHighestSales();
		printOutResults();
		
		sortByNameAndPrint();
	}
	
	private void sortByNameAndPrint() {
		
		Arrays.sort(team);
		
		System.out.println();
		
		for(Salesman sm: team) {
			System.out.println(sm.getName() +": " +sm.getSales());
		}
	}

	public void getData() {
	
		Scanner myScanner = new Scanner(System.in);
		
		System.out.println("Input the number sales men: ");
		numOfSalesman = myScanner.nextInt();		
		
		team = new Salesman[numOfSalesman];
		
		for(int i=0; i<numOfSalesman;i++) {
			
			myScanner.nextLine();
			
			System.out.println("Enter data for associate number" + (i+1));
			
			System.out.println("Enter name:");
			String name = myScanner.nextLine();
			
			System.out.println("Enter Sales:");
			double sales = myScanner.nextDouble();
			
			team[i] = new Salesman();
			
			team[i].setName(name);
			team[i].setSales(sales);
		}
		myScanner.close();
	}
	
	public void cacluateAverageSales() {
		
		double sum = 0;
		
		for(Salesman sm:team) {
			sum = sum + sm.getSales();
		}
		
		averageSales = sum/team.length;
	}
	
	public void calculateHighestSales() {
		Double currentHighestValue = 0.0;
		
		for(Salesman sm:team) {
			if(currentHighestValue < sm.getSales()) {
				currentHighestValue = sm.getSales();
			}
		}
		
		highestSales = currentHighestValue;
	}
	
	public void printOutResults() {
		
		System.out.println("Average: " + averageSales);
		System.out.println("Highest sales: " + highestSales);
		
		System.out.println("The Highest sales guy");
		
		for(Salesman sm:team) {
			if(sm.getSales() == highestSales) {
				System.out.println("Name: " + sm.getName());
				System.out.println("Sales: " + sm.getSales());
			}
		}
		
		System.out.println("The other sales guy");
		for(Salesman sm:team) {
			if(sm.getSales()!= highestSales) {
				System.out.println("Name: " + sm.getName());
				System.out.println("Sales: " + sm.getSales());
			}
		}
	}

}
