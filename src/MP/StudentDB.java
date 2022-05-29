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

	public boolean editData(String name, int SAISID, int choice, String edit) {
		try {
			Scanner sc = new Scanner(new File(name + " " + SAISID + ".txt"));
			sc.nextLine(); sc.nextLine();
			String num = sc.nextLine();
			String address = sc.nextLine();
			sc.close();
			
			switch(choice) {
				case 1:
					new File(name + " " + SAISID + ".txt").delete();
					name = edit;
					break;
				case 2:
					new File(name + " " + SAISID + ".txt").delete();
					SAISID = Integer.parseInt(edit);
					break;
				case 3:
					num = edit;
					break;
				case 4:
					address = edit;
			}
			
			StudentData dbd = new StudentData(name, SAISID, Integer.parseInt(num), address);
			return new StudentDB().addData(dbd);
		}
		catch (FileNotFoundException e) {
			return false;
		}
		
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
	public StudentData [] showData() {
		try {
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
		catch (FileNotFoundException e) {
			return new StudentData[0];
		}
		
	}
	
	// This function returns array of students that has been read 
	// from a list of text files that matched the search string.
	public StudentData [] searchData(String toSearch) {
		try {
			StudentData[] studentlist = showData();
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