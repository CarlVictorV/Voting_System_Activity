
/**
 * The main class for the voting system. This class contains the main method and
 * initializes the application by creating the necessary objects and launching
 * the login GUI.
 * 
 * @param args The command line arguments.
 * @return None.
 * @throws None.
 * 
 * @author Carl Victor Villaceran
 * @version 1.0
 * @contributor T-jay Abunales
 * @contributor Raynor Buhian
 */

 import java.util.ArrayList;
 import java.util.Scanner;
 
 public class Main {
 
	 // Array List
	 static ArrayList<User> users = new ArrayList<User>();
	 static ArrayList<Candidates> candidates = new ArrayList<Candidates>();
 
	 public static Scanner input = new Scanner(System.in);
 
	 public static void main(String[] args) {
 
		 users.add(new Superuser("Superuser", "a", "a"));
		 new GUI(users, candidates);
		 GUI.LoginGUI();
 
	 }
 
 }
 