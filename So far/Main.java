//This file will be an overall will be creating an Automated Voting System

//HIGH-Level Specifications:
//-The system should have 3 types of users: Superuser(Admin basically), Officer, and Voter
//-The supseruser can only add, remove, and update an officer and voter.
//-The officer can only add, remove, and update candidates.
//-The voter can only vote for a candidates.
//-The digital ballot should display the candidates for (3) President, (3) Vice President, (10) Senators, (10) District Representatives, (3) Governors, and (3) Mayors.
//-The voter can only submit his/her vote if it complies with the voting requirement below:
// -- 1 President, 1 Vice President, 5 Senators, 4 Representatives, 1 Governor, and 1 Mayor
// -- The voter cannot start voting unless the maximum number of candidates per position is satisfied.
//-If at least 1 voter has submitted his/her vote, an officer can no longer modify the roster of candidates.
//-A summary, preferably in a graphical form, of the number of votes per candidate should be available to all users.
//-However, voters can only view the report after they have submitted their vote.

//Technical Specifications:
//Implement the following:
//-Encapsulation
//-Inheritance
//-Polymorphism
//-Constructors Overloading
//-GUI (Required) Also the hardest for me, because I have no experience in GUI
//-JavaDoc (Required)

import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main {
	static ArrayList<User> users = new ArrayList<User>();
	static ArrayList<Candidates> candidates = new ArrayList<Candidates>();
	public static Scanner input = new Scanner(System.in);

	// create a global counter for the number of position
	public static int numPresident = 0;
	public static int numVicePresident = 0;
	public static int numSenator = 0;
	public static int numRepresentative = 0;
	public static int numGovernor = 0;
	public static int numMayor = 0;
	public static int numVoter = 0;
	public static int numVoterVoted = 0;
	public static JFrame frame;
	public static JLabel userLabel;
	public static JLabel passwordLabel;
	public static JTextField userText;
	public static JPasswordField passwordText;
	public static JButton loginButton;
	public static JButton cancelButton;

	public static void main(String[] args) {

		addDummy();
		// Make a for each loop for users

		LoginGUI();

	}

	// SuperUser
	public static void addOfficer() {
	}

	public static void addVoter() {
	}

	public static void editUser() {
	}

	public static void removeUser() {
	}

	public static void displayUser() // Should display all users and will be used mostly by
	{
	}

	// Officer
	public static void addCandidate() {
	}

	public static void editCandidate() {
	}

	public static void removeCandidate() {
	}

	public static void displayCandidate() {
	}

	// voters
	public static void voteCandidates() {
	}

	public static boolean candidateFull() // Purpose: To check if the number of candidates is equal to the number of
											// allowed candidates so that the voter can start voting.
	{
		// return true if the number of candidates is equal to the number of allowed
		// candidates.
		// return false if the number of candidates is less than the number of allowed
		// candidates.
		// Again stated above is the maximum number of candidates per position.

		if (numPresident == 3 && numVicePresident == 3 && numSenator == 10 && numRepresentative == 10
				&& numGovernor == 3 && numMayor == 3) {
			return true;
		} else {
			return false;
		}
	}

	// Global
	public static void logIn() {
	}

	public static void logOut() {
	}

	public static void voteSummary() {
	}

	public static void GUI() {
	}

	public static void addDummy() {
		users.add(new Superuser("Superuser", "superuser", "superuser"));
		users.add(new Officer("Officer", "officer", "officer"));
		users.add(new Voter("Voter", "voter", "voter"));
	}

	public static void LoginGUI() {
		frame = new JFrame("Login Form");
		frame.setSize(300, 150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(3, 2));

		userLabel = new JLabel("Username:");
		passwordLabel = new JLabel("Password:");
		userText = new JTextField(20);
		passwordText = new JPasswordField(20);
		loginButton = new JButton("Login");
		cancelButton = new JButton("Cancel");
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = userText.getText();
				String password = new String(passwordText.getPassword());
				boolean valid = false;
				for (int i = 0; i < users.size(); i++) {
					if (users.get(i).getUserName().equals(username) && users.get(i).getPassword().equals(password)) {
						if (users.get(i).getUserName().equals("superuser")) {
							frame.dispose();
							SuperUserMenuGUI();
						} else if (users.get(i).getUserName().equals("officer")) {
							frame.dispose();
							OfficerMenuGUI();
						} else if (users.get(i).getUserName().equals("voter")) {
							frame.dispose();
							VoterMenuGUI();
						}
						valid = true;
					}
				}

				if (valid == false) {
					JOptionPane.showMessageDialog(null, "Invalid Username or Password");
					userText.setText("");
					passwordText.setText("");
				} else {
					JOptionPane.showMessageDialog(null, "Login Successful\nWelcome " + username + "!");
				}

			}
		});

		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		frame.add(userLabel);
		frame.add(userText);
		frame.add(passwordLabel);
		frame.add(passwordText);
		frame.add(loginButton);
		frame.add(cancelButton);
		frame.setVisible(true);
	}

	public static void OfficerMenuGUI() {
		frame = new JFrame("Officer Menu");
		frame.setSize(300, 150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(3, 2));

		JButton addCandidateButton = new JButton("Add Candidate");
		JButton editCandidateButton = new JButton("Edit Candidate");
		JButton removeCandidateButton = new JButton("Remove Candidate");
		JButton displayCandidateButton = new JButton("Display Candidate");
		JButton logoutButton = new JButton("Logout");

        frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		addCandidateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// display add candidate form
				addCandidate();
			}
		});

		editCandidateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// display edit candidate form
				editCandidate();
			}
		});

		removeCandidateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// display remove candidate form
				removeCandidate();
			}
		});

		displayCandidateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// display display candidate form
				displayCandidate();
			}
		});

		logoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// display login form
                frame.dispose();
				LoginGUI();
			}
		});

		frame.add(addCandidateButton);
		frame.add(editCandidateButton);
		frame.add(removeCandidateButton);
		frame.add(displayCandidateButton);
		frame.add(logoutButton);
		frame.setVisible(true);
	}

	public static void VoterMenuGUI() {
		frame = new JFrame("Voter Menu");
		frame.setSize(300, 150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(3, 2));

		JButton voteButton = new JButton("Vote");
		JButton displayCandidateButton = new JButton("Display Candidate");
		JButton logoutButton = new JButton("Logout");

        frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		voteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// display vote form
				// VoteGUI();
			}
		});

		displayCandidateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// display display candidate form
				// DisplayCandidateGUI();
			}
		});

		logoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// display login form
                frame.dispose();
				LoginGUI();
			}
		});

		frame.add(voteButton);
		frame.add(displayCandidateButton);
		frame.add(logoutButton);
		frame.setVisible(true);
	}

	public static void SuperUserMenuGUI()// ADD USER SPECICALLY OFFICER AND VOTER
	{
		frame = new JFrame("Super User Menu");
		frame.setSize(300, 150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(3, 2));

		JButton addUserButton = new JButton("Add User");
		JButton editUserButton = new JButton("Edit User");
		JButton removeUserButton = new JButton("Remove User");
		JButton displayUserButton = new JButton("Display User");
		JButton logoutButton = new JButton("Logout");

        frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		addUserButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// display add user form
				// AddUserGUI();
			}
		});

		editUserButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// display edit user form
				// EditUserGUI();
			}
		});

		removeUserButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// display remove user form
				// RemoveUserGUI();
			}
		});

		displayUserButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// display display user form
				// DisplayUserGUI();
			}
		});

		logoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// display login form
                frame.dispose();
				LoginGUI();
			}
		});

		frame.add(addUserButton);
		frame.add(editUserButton);
		frame.add(removeUserButton);
		frame.add(displayUserButton);
		frame.add(logoutButton);
		frame.setVisible(true);
	}

}
