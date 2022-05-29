package MP;

public interface DBInterface {
	//Add data at the end of the database entries
	abstract boolean addData(StudentData dbd);
	//Delete Method – given the name of the Student to delete
	abstract boolean deleteData(String name, int SAISID);
	// Edit Data - given the name of the Student to edit
	abstract boolean editData(String name, int SAISID, int choice, String edit);
	// Search Data – given any substring to search- must retrieve all
	// Students with the substring passed in the parameter
	abstract StudentData [] searchData(String toSearch);
	// Prints all the contents of the Database list
	abstract StudentData[] showData();
}
