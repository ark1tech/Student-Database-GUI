package MP;

import java.io.*;
import java.util.*;

public class StudentDB implements DBInterface{
	
	static String name, address;
	static int id, num;
	
	public boolean addData() {
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
		
		br.close();
		
	}
	
	public static Integer parseTest (String str) {
		// This function checks if the user input can be parsed to an integer.
		// Refer to https://stackoverflow.com/questions/1486077/good-way-to-encapsulate-integer-parseint
		
		try { return Integer.parseInt(str); }
		catch (NumberFormatException e) {
			return 0; // Note: I'm not sure if this works. If it doesn't change to "return null".
		}
	}
	
	//Delete Method – given the name of the Student to delete
	abstract boolean deleteData(String name);
	// Search Data – given any substring to search- must retrieve all
	// Students with the substring passed in the parameter
	abstract boolean searchData(String toSearch);
	// Prints all the contents of the Database list
	abstract void showData();
	// Edit Data - given the name of the Student to edit
	abstract boolean editData(String name);
	
}
