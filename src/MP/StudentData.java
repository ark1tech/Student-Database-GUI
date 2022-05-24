package MP;

import java.io.*;
import java.util.*;

public class StudentData {
	
	String name, address;
	int id, num;
	
	static int n = 0;
	
	public StudentData(String name, int id, int num, String address) {
		this.name = name;
		this.id = id;
		this.num = num;
		this.address = address;
		n++;
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
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

}
