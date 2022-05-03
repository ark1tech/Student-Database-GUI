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
		System.out.print("Enter SAIS ID: ");
		id = parseTest(br.readLine());
		System.out.print("Enter student number: ");
		num = parseTest(br.readLine());
		System.out.print("Enter student address: ");
		address = br.readLine();
		
		printFile(name, Integer.toString(id), Integer.toString(num), address);
		
		// br.close();
	}
	
	public static Integer parseTest(String str) {
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
			System.out.println(name + "'s record has been deleted.");
		} else System.out.println("Student record does not exist.");
		
		// br.close();
	}

	public static void searchData(String toSearch) throws FileNotFoundException {
		// This function shows all available text files and searches through them.        
		
		File f = new File(".");
		File [] files = f.listFiles(filter());
		
        for (File file : files) {
        	Scanner sc = new Scanner(new File(file.getName()));
        	String dataLine = sc.nextLine(); sc.close();
        	if (dataLine.toLowerCase().contains(toSearch)) {
        		String [] data = dataLine.split("\\s");
        		for (String datum : data) {
        			System.out.print("\n" + datum);
        		}
        	} System.out.println();
        	
        }
	}
	
	public static void showData() {
		// This function shows all available text files.
		
		File f = new File(".");
		File [] files = f.listFiles(filter());
		
		int n = 1;
		for (File file : files) {
			System.out.print("\n" + n + " " + file.getName().replace(".txt", "")); n++;
		} System.out.println();
	}
	
	public static void editData() throws IOException {
		
		showData();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		File f = new File(".");
		File [] files = f.listFiles(filter());
		
		System.out.print("\nWhich file do you wish to modify? ");
		int ans = parseTest(br.readLine());
		
		while (ans < 1 || ans > files.length) {
			System.out.print("\nInvalid input. Which file do you wish to modify? ");
			ans = parseTest(br.readLine());
		}
		
		Scanner sc = new Scanner(new File(files[ans - 1].getName())); ans = 0;
		String dataLine = sc.nextLine(); sc.close();
		String [] data = dataLine.split("\\s");
		for (String datum : data) {
			System.out.print("\n" + datum);
		} System.out.println();
		
		while (ans < 1 || ans > 4) {
			System.out.print("\nWhat do you want to modify?\n[1] Name.\n[2] SAIS ID.\n[3] Student Number.\n[4] Address.\n: ");
			ans = parseTest(br.readLine());
		}
		
		
		switch(ans) {
			case 1:
				deleteData(data[ans - 1]);
				System.out.print("\nEnter student name: ");
				data[ans - 1] = br.readLine(); break;
			case 2:
				System.out.print("Enter SAIS ID: ");
				data[ans - 1] = parseTest(br.readLine()).toString(); break;
			case 3:
				System.out.print("Enter student number: ");
				data[ans - 1] = parseTest(br.readLine()).toString(); break;
			case 4:
				System.out.print("Enter student address: ");
				data[ans - 1] = br.readLine();
		}
		
		printFile(data[0], data[1], data[2], data[3]);
		
	}
	
	public static FilenameFilter filter () {
		
		FilenameFilter textFilter = new FilenameFilter() {
			public boolean accept(File dir, String filename) {
				return filename.toLowerCase().endsWith(".txt");
			}
		};
		
		return textFilter;
	}
	
	public static void printFile(String name, String id, String num, String address) throws FileNotFoundException {
		
		PrintWriter pw = new PrintWriter(name + ".txt");
		pw.print(name + " " + id + " " + num + " " + address);
		pw.close();
		
	}
	
	public static void main (String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while (!ans.equals("0")) {
			System.out.print("\nWhat do you want to test?\n[1] addData().\n[2] deleteData().\n[3] searchData().\n[4] showData().\n[5] editData().\n[0] End program.\n   Prompt: ");
			ans = br.readLine();
			
			if (ans.equals("0")) {
				System.out.println("\nProgram Terminated.");
			}
		
			if (ans.equals("1")) {
				addData();
			}
			
			if (ans.equals("2")) {
				System.out.print("\nEnter student name: ");
				deleteData(br.readLine());
			}
			
			if (ans.equals("3")) {
				System.out.print("\nEnter search entry: ");
				searchData(br.readLine());
			}
			
			if (ans.equals("4")) {
				showData();
			}
			
			if (ans.equals("5")) {
				editData();
			}
		}
		
	}
	
}