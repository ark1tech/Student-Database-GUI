package MP;

import java.io.*;
import java.util.*;

public class StudentDB implements DBInterface {

	// This function shows all available text files and searches through them.
	public boolean addData(StudentData dbd) {

		try {
			printFile(dbd);
			return true;
		}
		catch (FileNotFoundException e) {
			return false;
		}

	}

	// This function deletes a database entry using name and SAISID integrated in the text file name.
	public boolean deleteData(String name, int SAISID) {
		

		if(new File(name + " " + SAISID + ".txt").delete()){
			return true;
		}
		else {
			return false;
		}
	}

	public boolean editData(String name, int SAISID) {
//
//		showData();
//
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		File f = new File(".");
//		File [] files = f.listFiles(filter());
//
//		try {
//			Scanner sc = new Scanner(new File(name)); int ans = 0;
//			String dataLine = sc.nextLine(); sc.close();
//			String [] data = dataLine.split("\\s");
//			for (String datum : data) {
//				System.out.print("\n" + datum);
//			} System.out.println();
//
//			while (ans < 1 || ans > 4) {
//				System.out.print("\nWhat do you want to modify?\n[1] Name.\n[2] SAIS ID.\n[3] Student Number.\n[4] Address.\n: ");
//				ans = parseTest(br.readLine());
//			}
//
//
//			switch(ans) {
//			case 1:
//				// deleteData(data[ans - 1]); paki integrate yung SAIS ID thx po 
//				System.out.print("\nEnter student name: ");
//				data[ans - 1] = br.readLine(); break;
//			case 2:
//				System.out.print("Enter SAIS ID: ");
//				data[ans - 1] = parseTest(br.readLine()).toString(); break;
//			case 3:
//				System.out.print("Enter student number: ");
//				data[ans - 1] = parseTest(br.readLine()).toString(); break;
//			case 4:
//				System.out.print("Enter student address: ");
//				data[ans - 1] = br.readLine();
//			}
//
//			//printFile(data[0], data[1], data[2], data[3]); FIX THIS !!!
//			return true;
//		}
//		catch(Exception e) {
//			
//		}
		return false;
	}

	public void showData() {
//		// This function shows all available text files.
//
//		File f = new File(".");
//		File [] files = f.listFiles(filter());
//
//		int n = 1;
//		try {
//			for (File file : files) {
//				System.out.print("\nEntry " + n); n++;
//				Scanner sc = new Scanner(new File(file.getName()));
//				//String dataLine = sc.nextLine(); sc.close();
//				//String [] data = dataLine.split("\\s");
//				while (sc.hasNextLine()) {
//					System.out.print("\n" + sc.nextLine());
//				}
//				System.out.println();
//			} System.out.println();
//		}
//		catch(FileNotFoundException e) {
//			e.printStackTrace();
//		}
	}
	
	// This function filters text files from the current directory.
	public static FilenameFilter filter () {

		FilenameFilter textFilter = new FilenameFilter() {
			public boolean accept(File dir, String filename) {
			return filename.toLowerCase().endsWith(".txt");
			}
		};

		return textFilter;
	}

	// This function writes an entry into a text file. 
	public static void printFile(StudentData dbd) throws FileNotFoundException {

		PrintWriter pw = new PrintWriter(dbd.name + " " + dbd.SAISID + ".txt");
		pw.print(dbd.name + "\n" + dbd.SAISID + "\n" + dbd.num + "\n" + dbd.address);
		pw.close();

	}
	
	// This function returns array of students that has been read from a list of text files.
	public static StudentData [] read() throws FileNotFoundException {
		File fileHolder = new File(".");
		File [] files = fileHolder.listFiles(filter());
		StudentData [] studentList = new StudentData[10];
		int fileCount = 0;
        for (File file : files) {
			Scanner sc = new Scanner(new File(file.getName()));
			String name = sc.nextLine();
			String id = sc.nextLine();
			String num = sc.nextLine();
			String address = sc.nextLine();
			studentList[fileCount] = new StudentData(name, Integer.parseInt(id), Integer.parseInt(num), address);
			sc.close(); fileCount++;
        }
        StudentData [] students = new StudentData[fileCount];
        for (int fileCount2 = 0; fileCount2 < fileCount; fileCount2++) {
        	students[fileCount2] = studentList[fileCount2];
        }
        return students;
	}
	
	// This function returns array of students that has been read 
	// from a list of text files that matched the search string.
	public StudentData [] searchData(String toSearch) {
		try {
			StudentData[] studentlist = read();
			StudentData[] students = new StudentData[10];
			int fileCount = 0, fileCount2 = 0;
			fileCount = 0;
			for (StudentData student : studentlist) {
				String dataLine = student.name + Integer.toString(student.SAISID) + Integer.toString(student.num) + student.address;
				if (dataLine.toLowerCase().contains(toSearch.toLowerCase())) {
					students[fileCount] = student;
					fileCount++;
				}
			}
			StudentData[] searches = new StudentData[fileCount];
			for (fileCount2 = 0; fileCount2 < fileCount; fileCount2++) {
				searches[fileCount2] = students[fileCount2];
			} return searches;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}