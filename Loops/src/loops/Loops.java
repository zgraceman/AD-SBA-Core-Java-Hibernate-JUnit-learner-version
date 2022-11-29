package loops;

import java.util.Scanner;

public class Loops {
	
	public static Scanner sc=new Scanner(System.in);

	// Question 1
	public static void multiplicationTable() {
		
		/* Write a program that uses for loops to print a multiplication table.*/
		
		for (int i = 1; i <= 12; i++) {
			System.out.print("\n" + i + " ");
			for (int j = 2; j <= 12; j++) {
				System.out.print(j*i + " ");
			}
		}
	}
	
	// Question 2
	public static void greatestCommonDivisor() {
		
		/* Write a program that prompts the user to enter two positive integers, and find their greatest common divisor (GCD).*/
		
		System.out.print("Enter positive integer: ");
		int a = sc.nextInt();
		System.out.print("Enter another positive integer: ");
		int b = sc.nextInt();
		int gcd = 1;
		
		for (int i = 1; i <= a && i <= b; i++) {
			if (a%i == 0 && b%i == 0) {
				gcd = i;
			}
		}
		System.out.println("Greatest common divisor = " + gcd);
		
	}
	
	// Question 3
	public static void predictFutureTuition() {
		
		/* Suppose the tuition for a university is $10,000 for the current year and increases by 7% every year
		 * In how many years will the tuition be doubled?*/
		int years = 0;
		double tuition = 10000;
		do {
			tuition = tuition * 1.07;
			years++;
		}
		while (tuition < 20000);
		System.out.println("In " + years + " years tuition will have doubled.");
	}
	
	public static void main(String[] args) {
		
		// System.out.println("Question 1:"); multiplicationTable(); // Question 1 
		// System.out.println("\nQuestion 2:"); greatestCommonDivisor(); // Question 2 
		System.out.println("\nQuestion 3:"); predictFutureTuition(); // Question 3

	}

}
