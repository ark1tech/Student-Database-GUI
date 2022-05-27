package MP;

import java.io.*;
import java.util.*;

public class StudentData {
	
	int fileCount = new File(".").listFiles(StudentDB.filter()).length;
	
	String name, address;
	int SAISID, num;
	
	public StudentData(String name, int SAISID, int num, String address) {
		this.name = name;
		this.SAISID = SAISID;
		this.num = num;
		this.address = address;
		fileCount++;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getId() {
		return SAISID;
	}

	public void setId(int SAISID) {
		this.SAISID = SAISID;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

}
