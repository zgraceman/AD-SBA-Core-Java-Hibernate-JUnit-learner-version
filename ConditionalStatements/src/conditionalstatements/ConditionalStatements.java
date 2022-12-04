package conditionalstatements;

import java.util.Arrays;
import java.util.Scanner;

public class ConditionalStatements {

public static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.println("Question 1:"); ifX(); // Question 1 
		System.out.println("\nQuestion 2:"); ifElseX(); // Question 2 
		System.out.println("\nQuestion 3:"); ifElseIfX(); // Question 3
		System.out.println("\nQuestion 4:"); conditonalOr(); // Question 4
		System.out.println("\nQuestion 5:"); ifElseIfGrades(); // Question 5
		System.out.println("\nQuestion 6:"); switchDays(); // Question 6
		System.out.println("\nQuestion 7:"); calculateMaringalTaxRate(); // Question 7

		
	}
	
	// Question 1
	public static void ifX() {
		/* Write a program that declares 1 integer variable x, and then assigns 7 to it. 
		 * Write an if statement to print out “Less than 10” if x is less than 10. 
		 * Change x to equal 15, and notice the result (console should not display anything).*/
		
		int x = 7;
		if (x < 10) {
			System.out.println("Less than 10");
		}
		x = 15;
		if (x < 10) {
			System.out.println("Less than 10");
		}
	}
	
	// Question 2
	public static void ifElseX() {
		/* Write a program that declares 1 integer variable x, and then assigns 7 to it. 
		 * Write an if-else statement that prints out “Less than 10” if x is less than 10, 
		 * and “Greater than 10” if x is greater than 10. 
		 * Change x to 15 and notice the result.*/
		
		int[] x = {7, 15};
		for (int i = 0; i < 2; i++) {
			if (x[i] < 10) {
				System.out.println("Less than 10");
			}
			else {
				System.out.println("Greater than 10");
			}
		}
		
	}
	// Question 3
	public static void ifElseIfX() {
		/* Write a program that declares 1 integer variable x, and then assigns 15 to it. 
		 * Write an if-else-if statement that prints out “Less than 10” if x is less than 10; 
		 * “Between 10 and 20” if x is greater than 10 but less than 20, 
		 * and “Greater than or equal to 20” if x is greater than or equal to 20. 
		 * Change x to 50 and notice the result.*/
		
		int[] x = {15, 20};
		for (int i = 0; i < 2; i++) {
			if (x[i] < 10) {
				System.out.println("Less than 10");
			}
			else if (x[i] >= 10 && x[i] < 20) {
				System.out.println("Between 10 and 20");
			}
			else {
				System.out.println("Greater than or equal to 20");
			}
		}
	}
	// Question 4
	public static void conditonalOr() {
		/* Write a program that declares 1 integer variable x, and then assigns 15 to it. 
		 * Write an if-else statement that prints “Out of range” if the number is less than 10 or greater than 20 
		 * and prints “In range” if the number is between 10 and 20 
		 * (including equal to 10 or 20). Change x to 5 and notice the result.*/
		
		
		int[] x = {15, 5};
		for (int i = 0; i < 2; i++) {
			if (x[i] < 10 || x[i] > 20) {
				System.out.println(x[i] + " Out of range");
			}
			else {
				System.out.println(x[i] + " In range");
			}
		}
	}
	
	// Question 5
	public static void ifElseIfGrades() {
		/*  Write a program that uses if-else-if statements to print out grades 
		 * A, B, C, D, F according to the following criteria: A: 90-100 B: 80-89 C: 70-79 D: 60-69 F: <60 
		 * Use the Scanner class to accept a number score from the user to determine the letter grade. 
		 * Print out “Score out of range” if the score is less than 0 or greater than 100.*/
		
		System.out.print("Enter grade: ");
		double grade = sc.nextDouble();
		if (grade >= 90 && grade <= 100) {
			System.out.println("A");
		}
		else if (grade >= 80 && grade <= 89) {
			System.out.println("B");
		}
		else if (grade >= 70 && grade <= 79) {
			System.out.println("C");
		}
		else if (grade >= 60 && grade <= 69) {
			System.out.println("D");
		}
		else if (grade < 60) {
			System.out.println("F");
		}
		else {
			System.out.println("Score out of range");
		}
			
	}
	// Question 6
	public static void switchDays() {
		/* Write a program that accepts an integer between 1 and 7 from the user. 
		 * Use a switch statement to print out the corresponding weekday. 
		 * Print “Out of range” if the number is less than 1 or greater than 7. 
		 * Do not forget to include “break” statements in each of your cases.*/
		
		System.out.print("Enter integer 1-7: ");
		int day = sc.nextInt();
		if (day < 1 || day > 7) {
			System.out.println("Out of range");
		}
		else {
			switch (day) {
			case 1:
				System.out.println("Sunday");
				break;
			case 2:
				System.out.println("Monday");
				break;
			case 3:
				System.out.println("Tuesday");
				break;
			case 4:
				System.out.println("Wednesday");
				break;
			case 5:
				System.out.println("Thursday");
				break;
			case 6:
				System.out.println("Friday");
				break;
			default:
				System.out.println("Satuday");
			}
		}
	}
	
	// Question 7
	public static void calculateMaringalTaxRate() {
		/* Create a program that lets the users input their filing status and income. 
		 * Display how much tax the user would have to pay according to status and income.*/
		
		System.out.print("Enter your annual income: ");
		int income = sc.nextInt();
		System.out.println("Enter your filing status (type Single, Married, or Head of Household) ");
		String status = sc.next().toLowerCase();
		if (status.equals("single")) {
			if (income > 0 && income < 8351) {
				System.out.println("Your Maringal Tax Rate is 10%");
			}
			else if (income > 8352 && income < 33951) {
				System.out.println("Your Maringal Tax Rate is 15%");
			}
			else if (income > 33952 && income < 82251) {
				System.out.println("Your Maringal Tax Rate is 25%");
			}
			else if (income > 82252 && income < 171551) {
				System.out.println("Your Maringal Tax Rate is 28%");
			}
			else if (income > 171552 && income < 372951) {
				System.out.println("Your Maringal Tax Rate is 33%");
			}
			else {
				System.out.println("Your Maringal Tax Rate is 35%");
			}
			
		}
		else if (status.equals("married")) {
			System.out.println("Are you filing jointly or seperately? (type jointly or seperately)");
			String marriedStatus = sc.next().toLowerCase();
			if (marriedStatus.equals("jointly")) { // Married Jointly
				if (income > 0 && income < 16701) {
					System.out.println("Your Maringal Tax Rate is 10%");
				}
				else if (income > 16702 && income < 67901) {
					System.out.println("Your Maringal Tax Rate is 15%");
				}
				else if (income > 67902 && income < 137051) {
					System.out.println("Your Maringal Tax Rate is 25%");
				}
				else if (income > 137052 && income < 208851) {
					System.out.println("Your Maringal Tax Rate is 28%");
				}
				else if (income > 208852 && income < 372951) {
					System.out.println("Your Maringal Tax Rate is 33%");
				}
				else {
					System.out.println("Your Maringal Tax Rate is 35%");

				} 
			} //
			else { // Married Seperately
				if (income > 0 && income < 8351) {
					System.out.println("Your Maringal Tax Rate is 10%");
				}
				else if (income > 8352 && income < 33951) {
					System.out.println("Your Maringal Tax Rate is 15%");
				}
				else if (income > 33952 && income < 68526) {
					System.out.println("Your Maringal Tax Rate is 25%");
				}
				else if (income > 68927 && income < 104426) {
					System.out.println("Your Maringal Tax Rate is 28%");
				}
				else if (income > 104427 && income < 186476) {
					System.out.println("Your Maringal Tax Rate is 33%");
				}
				else {
					System.out.println("Your Maringal Tax Rate is 35%");
				}
			} //
		}
		else { // Head of Household
			if (income > 0 && income < 11951) {
				System.out.println("Your Maringal Tax Rate is 10%");
			}
			else if (income > 11952 && income < 45501) {
				System.out.println("Your Maringal Tax Rate is 15%");
			}
			else if (income > 45502 && income < 117451) {
				System.out.println("Your Maringal Tax Rate is 25%");
			}
			else if (income > 117452 && income < 190201) {
				System.out.println("Your Maringal Tax Rate is 28%");
			}
			else if (income > 190202 && income < 372951) {
				System.out.println("Your Maringal Tax Rate is 33%");
			}
			else {
				System.out.println("Your Maringal Tax Rate is 35%");
			}
		} //
	}
}
