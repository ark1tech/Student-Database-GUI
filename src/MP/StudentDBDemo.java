package MP;

import java.awt.EventQueue;
import java.io.FileNotFoundException;

public class StudentDBDemo {

	public static void main(String[] args) throws FileNotFoundException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new StudentDB();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
	}
	
}
