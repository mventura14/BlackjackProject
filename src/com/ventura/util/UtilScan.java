package com.ventura.util;

import java.util.Scanner;

public class UtilScan {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String message = "Please enter an integer: ";
		int user = inputValidation(sc, "int", message);
		System.out.println(user);
		
		message = "Please enter a double: ";
		double userdouble = inputValidation(sc, "double", message);
		System.out.println(userdouble);

	}

	@SuppressWarnings("unchecked")
	public static <T> T inputValidation(Scanner sc, String type, String message) {

		switch (type) {
		case "int":
			return (T) Integer.valueOf(intScan(sc, message));

		case "double":
			return (T) Double.valueOf(doubleScan(sc, message));

		default:
			return null;
		}
	}

	public static double doubleScan(Scanner sc, String message) {
		double userInput = 0;
		boolean isValidInput = false;

		while (!isValidInput) {
			System.out.print(message);
			if (sc.hasNextDouble()) {
				userInput = sc.nextDouble();
				isValidInput = true;
			} else {
				sc.next();
			}
		}
		return userInput;
	}

	public static int intScan(Scanner sc, String message) {
		int userInput = 0;
		boolean isValidInput = false;

		while (!isValidInput) {
			System.out.print(message);
			if (sc.hasNextInt()) {
				userInput = sc.nextInt();
				isValidInput = true;
			} else {
				sc.next();
			}
		}
		
	

		return userInput;
	}
	
//	public static void examplereader() {
//			
//		try ( BufferedReader bufIn = new BufferedReader(new FileReader("input.txt")) ) {
//			  String line;
//			  while ((line = bufIn.readLine()) != null) {
//			    System.out.println(line);
//			  }
//			}
//			catch (IOException e) {
//			  System.err.println(e);
//			}
//			
//			
//		};
		
//		public static void exampleWriter() {
//			
//			  String[] data = { "Cat", "Dog", "Frog", "Giraffe" };
//			  
//			  
//			  try {
//			    FileWriter fw = new FileWriter("test.txt");
//			    PrintWriter pw = new PrintWriter(fw);
//			    for (String string : data) {
//			      pw.println(string);
//			    }
//			    pw.close();
//			  }
//			  catch (IOException e) {
//			    e.printStackTrace();
//			  }
//			}
//			
//			
//			
//		};
	
}
