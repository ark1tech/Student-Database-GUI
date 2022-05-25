package MP;

import java.io.*;
import java.util.*;

public class StudentDB implements DBInterface {

	static String ans = "4", name, address;
	static int id, num;

	public boolean addData(StudentData dbd) {

		try {
			printFile(dbd);
			return true;
		}
		catch (FileNotFoundException e) {
			return false;
		}

	}

	public static Integer parseTest(String str) {
		// This function checks if the user input can be parsed to an integer.
		// Refer to https://stackoverflow.com/questions/1486077/good-way-to-encapsulate-integer-parseint

		try { return Integer.parseInt(str); }
		catch (NumberFormatException e) {
			return 0; // Note: I'm not sure if this works. If it doesn't change to "return null".
		}
	}

	public boolean editData(String name, int SAISID) {

		showData();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		File f = new File(".");
		File [] files = f.listFiles(filter());

		try {
			Scanner sc = new Scanner(new File(name)); int ans = 0;
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
				// deleteData(data[ans - 1]); paki integrate yung SAIS ID thx po 
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

			//printFile(data[0], data[1], data[2], data[3]); FIX THIS !!!
			return true;
		}
		catch(Exception e) {
			return false;
		}

	}

	public boolean deleteData(String name, int SAISID) {
		// This function deletes a database entry.

		/* Note: This is an alternative to using a parameter.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("\nEnter student name: ");
		name = br.readLine();
		 */

		if(new File(name + " " + id + ".txt").delete()){
			return true;
		}
		else {
			return false;
		}
		// br.close();
	}

	public boolean searchData(String toSearch) {
		// This function shows all available text files and searches through them.        

		File f = new File(".");
		File [] files = f.listFiles(filter());

		try {
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
			return true;
		}
		catch(FileNotFoundException e) {
			return false;
		}
	}

	public void showData() {
		// This function shows all available text files.

		File f = new File(".");
		File [] files = f.listFiles(filter());

		int n = 1;
		try {
			for (File file : files) {
				System.out.print("\nEntry " + n); n++;
				Scanner sc = new Scanner(new File(file.getName()));
				//String dataLine = sc.nextLine(); sc.close();
				//String [] data = dataLine.split("\\s");
				while (sc.hasNextLine()) {
					System.out.print("\n" + sc.nextLine());
				}
				System.out.println();
			} System.out.println();
		}
		catch(FileNotFoundException e) {
			// DO SOMETHING.
		}
	}

	public static FilenameFilter filter () {

		FilenameFilter textFilter = new FilenameFilter() {
			public boolean accept(File dir, String filename) {
				return filename.toLowerCase().endsWith(".txt");
			}
		};

		return textFilter;
	}

	public static void printFile(StudentData dbd) throws FileNotFoundException {

		PrintWriter pw = new PrintWriter(dbd.name + " " + dbd.id + ".txt");
		pw.print(dbd.name + "\n" + dbd.id + "\n" + dbd.num + "\n" + dbd.address);
		pw.close();

	}

	/*
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
	 */

}