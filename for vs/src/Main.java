
//Necessary
import java.util.ArrayList;
import java.util.Scanner;

//For GUI. Can be added to a new GUI Class
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Main {

	// Array List
	static ArrayList<User> users = new ArrayList<User>(); // Can be added to the User super class
	static ArrayList<Candidates> candidates = new ArrayList<Candidates>(); // Can be added to the candidaetes super
																			// class
	// Scanner
	public static Scanner input = new Scanner(System.in); // This should stay here
	// Counter
	public static int numPresident = 0; // I think its preferable to stay here or we can add this as a static variable
										// to the class
	public static int numVicePresident = 0; // I think its preferable to stay here or we can add this as a static
											// variable to the class
	public static int numSenator = 0; // I think its preferable to stay here or we can add this as a static variable
										// to the class
	public static int numDistrictRepresentative = 0; // I think its preferable to stay here or we can add this as a
														// static variable to the class
	public static int numGovernor = 0; // I think its preferable to stay here or we can add this as a static variable
										// to the class
	public static int numMayor = 0; // I think its preferable to stay here or we can add this as a static variable
									// to the class
	public static int numVoterVoted = 0; // I think its preferable to stay here or we can add this as a static variable
											// to the class
	// GUI Variables. Can be put into a GUI class later

	// Main Method
	public static void main(String[] args) {

		// Add dummy data
		addDummy();
		// Start of the program that can be added to the GUI later
		LoginGUI loginGUI = new LoginGUI();
        loginGUI.setVisible(true);

	}
	public static boolean candidateVoted() {
		for (int i = 0; i < candidates.size(); i++) {
			if (candidates.get(i).getVotes() > 0) {
				return true;
			}
		}
		return false;
	}

	public static boolean candidateFull() {
		if (numPresident == 3 && numVicePresident == 3 && numSenator == 10 && numDistrictRepresentative == 10
				&& numGovernor == 3 && numMayor == 3) {
			return true;
		} else {
			return false;
		}
	}	

	public static void addDummy() {
		users.add(new Superuser("Superuser", "a", "a"));
		users.add(new Officer("Officer", "b", "b"));
		users.add(new Voter("Voter", "c", "c"));
		users.add(new Voter("Voter", "cc", "cc", true));

		// Add candidates
		candidates.add(new President("President", "A President", 0));
		candidates.add(new President("President", "B President", 0));
		candidates.add(new President("President", "C President", 0));

		candidates.add(new VicePresident("Vice President", "A Vice President", 0));
		candidates.add(new VicePresident("Vice President", "B Vice President", 0));
		candidates.add(new VicePresident("Vice President", "C Vice President", 0));

		// Class Senators
		candidates.add(new Senators("Senator", "A Senator", 0));
		candidates.add(new Senators("Senator", "B Senator", 0));
		candidates.add(new Senators("Senator", "C Senator", 0));
		candidates.add(new Senators("Senator", "D Senator", 0));
		candidates.add(new Senators("Senator", "E Senator", 0));
		candidates.add(new Senators("Senator", "F Senator", 0));
		candidates.add(new Senators("Senator", "G Senator", 0));
		candidates.add(new Senators("Senator", "H Senator", 0));
		candidates.add(new Senators("Senator", "I Senator", 0));
		candidates.add(new Senators("Senator", "J Senator", 0));

		// Class DistrictRepresentative
		candidates.add(new DistrictRepresentatives("District Representative", "A District Representative", 0));
		candidates.add(new DistrictRepresentatives("District Representative", "B District Representative", 0));
		candidates.add(new DistrictRepresentatives("District Representative", "C District Representative", 0));
		candidates.add(new DistrictRepresentatives("District Representative", "D District Representative", 0));
		candidates.add(new DistrictRepresentatives("District Representative", "E District Representative", 0));
		candidates.add(new DistrictRepresentatives("District Representative", "F District Representative", 0));
		candidates.add(new DistrictRepresentatives("District Representative", "G District Representative", 0));
		candidates.add(new DistrictRepresentatives("District Representative", "H District Representative", 0));
		candidates.add(new DistrictRepresentatives("District Representative", "I District Representative", 0));
		candidates.add(new DistrictRepresentatives("District Representative", "J District Representative", 0));

		candidates.add(new Governer("Governor", "A Governor", 0));
		candidates.add(new Governer("Governor", "B Governor", 0));
		candidates.add(new Governer("Governor", "C Governor", 0));

		candidates.add(new Mayor("Mayor", "A Mayor", 0));
		candidates.add(new Mayor("Mayor", "B Mayor", 0));
		candidates.add(new Mayor("Mayor", "C Mayor", 0));

		// Set all number of candidates to max

		numPresident = 3;
		numVicePresident = 3;
		numSenator = 10;
		numDistrictRepresentative = 10;
		numGovernor = 3;
		numMayor = 3;

	}
	
}
