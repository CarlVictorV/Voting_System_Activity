
//Necessary
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	// Array List
	static ArrayList<User> users = new ArrayList<User>(); 
	static ArrayList<Candidates> candidates = new ArrayList<Candidates>(); 
	
	public static Scanner input = new Scanner(System.in); 
	
	public static void main(String[] args) {
		users.add(new Superuser("Superuser", "a", "a"));
		GUI loginGUI = new GUI(users,candidates);
		loginGUI.setVisible(true);

	}

}
