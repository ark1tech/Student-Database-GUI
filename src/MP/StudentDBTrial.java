package MP;

import java.io.*;
import java.util.*;

public class StudentDBTrial {
	
	static String ans = "4", name, address;
	static int id, num;
	
	public static void addData() throws IOException {
		// This function adds new database entry by printing it to a .txt file.
		// Note: I removed the parameter for now.
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("\nEnter student name: ");
		name = br.readLine();
		System.out.print("\nEnter SAIS ID: ");
		id = parseTest(br.readLine());
		System.out.print("\nEnter student number: ");
		num = parseTest(br.readLine());
		System.out.print("\nEnter student address: ");
		address = br.readLine();
		
		PrintWriter pw = new PrintWriter (name + ".txt");
		pw.print(id + " " + num + " " + address);
		pw.close();
		
		// br.close();
	}
	
	public static Integer parseTest (String str) {
		// This function checks if the user input can be parsed to an integer.
		// Refer to https://stackoverflow.com/questions/1486077/good-way-to-encapsulate-integer-parseint
		
		try { return Integer.parseInt(str); }
		catch (NumberFormatException e) {
			return 0; // Note: I'm not sure if this works. If it doesn't change to "return null".
		}
	}
	
	public static void deleteData(String name) {
		// This function deletes a database entry.
		
		/* Note: This is an alternative to using a parameter.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("\nEnter student name: ");
		name = br.readLine();
		*/
		
		if(new File(name + ".txt").delete()){
			System.out.println("\n" + name + "'s record has been deleted.");
		} else System.out.println("\nStudent record does not exist.");
		
		// br.close();
	}
	
	// Search Data – given any substring to search- must retrieve all
	// Students with the substring passed in the parameter
	//abstract boolean searchData(String toSearch);
	// Prints all the contents of the Database list
	//abstract void showData();
	// Edit Data - given the name of the Student to edit
	//abstract boolean editData(String name);
	
	public static void main (String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while (!ans.equals("0")) {
			System.out.print("\nWhat do you want to do?\n[1] Set new allocations.\n[2] Input student's grade.\n[3] Modify student's grade.\n[4] Display student's grade.\n[5] Delete student record.\n[0] End program.\n   Prompt: ");
			ans = br.readLine();
			
			if (ans.equals("0")) {
				System.out.println("\nProgram Terminated.");
			}
		
			if (ans.equals("1")) {
				addData();
			}
			
			if (ans.equals("2")) {
				System.out.print("\nEnter student name: ");
				name = br.readLine();
				deleteData(name);
			}
			
			if (ans.equals("3")) {
				
			}
			
			if (ans.equals("4")) {
				
			}
			
			if (ans.equals("5")) {
				
			}
		}
		
	}
	
}