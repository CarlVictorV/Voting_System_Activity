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

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Main {
	static ArrayList<User> users = new ArrayList<User>();
	static ArrayList<Candidates> candidates = new ArrayList<Candidates>();
	public static Scanner input = new Scanner(System.in);

	// create a global counter for the number of position
	public static int numPresident = 0;
	public static int numVicePresident = 0;
	public static int numSenator = 0;
	public static int numDistrictRepresentative = 0;
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
	public static JLabel success;
	public static JLabel label;

	public static void main(String[] args) {

		addDummy();
		// Make a for each loop for users

		LoginGUI();

	}

	// Officer

	public static void editCandidate() {
	}

	public static void removeCandidate() {
	}

	public static void displayCandidate() {
	}

	// voters
	public static void voteCandidates() {
	}

	public static boolean candidateFull() {
		if (numPresident == 3 && numVicePresident == 3 && numSenator == 10 && numDistrictRepresentative == 10
				&& numGovernor == 3 && numMayor == 3) {
			return true;
		} else {
			return false;
		}
	}

	// Global
	// Create a method that will check if there is a candidate that has been voted
	public static boolean candidateVoted() {
		for (int i = 0; i < candidates.size(); i++) {
			if (candidates.get(i).getVotes() > 0) {
				return true;
			}
		}
		return false;
	}

	public static void voteSummaryGUI() {
	}

	public static void addDummy() {
		users.add(new Superuser("Superuser", "a", "a"));
		users.add(new Officer("Officer", "b", "b"));
		users.add(new Voter("Voter", "voter", "voter"));
	}

	public static void LoginGUI() {
		frame = new JFrame("Login Form");
		frame.setSize(300, 150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(3, 2));
		frame.setResizable(false);

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

						// Dont check the username check the instance of the object
						if (users.get(i) instanceof Superuser) {
							frame.dispose();
							SuperUserMenuGUI();
						} else if (users.get(i) instanceof Officer) {
							frame.dispose();
							OfficerMenuGUI();
						} else if (users.get(i) instanceof Voter) {
							frame.dispose();
							VoterMenuGUI(i);
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

	public static void SuperUserMenuGUI()// ADD USER SPECICALLY OFFICER AND VOTER
	{
		frame = new JFrame("Super User Menu");
		frame.setSize(300, 150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(3, 2));
		frame.setResizable(false);
		JButton addUserButton = new JButton("Add User");
		JButton editUserButton = new JButton("Edit User");
		JButton removeUserButton = new JButton("Remove User");
		JButton displayUserButton = new JButton("Display User");
		JButton voteSummaryButton = new JButton("Vote Summary");
		JButton logoutButton = new JButton("Logout");

		addUserButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// display add user form
				AddUserGUI();
			}
		});

		editUserButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// display edit user form
				EditUserGUI();
			}
		});

		removeUserButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// display remove user form
				RemoveUserGUI();
			}
		});

		displayUserButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// display display user form
				DisplayUserGUI();
			}
		});

		voteSummaryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// display vote summary form
				voteSummaryGUI();
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
		frame.add(voteSummaryButton);
		frame.add(logoutButton);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	public static void AddUserGUI() {
		frame = new JFrame("Add User");
		frame.setSize(300, 150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(3, 2));

		JLabel nameLabel = new JLabel("Name:");
		JLabel usernameLabel = new JLabel("Username:");
		JLabel passwordLabel = new JLabel("Password:");
		JLabel typeLabel = new JLabel("Type:");

		JTextField nameText = new JTextField(20);
		JTextField usernameText = new JTextField(20);
		JTextField passwordText = new JTextField(20);

		String[] type = { "Officer", "Voter" };
		JComboBox<Object> typeList = new JComboBox<Object>(type);

		JButton submitButton = new JButton("Submit");
		JButton cancelButton = new JButton("Cancel");

		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = nameText.getText();
				String username = usernameText.getText();
				String password = passwordText.getText();
				String userType = (String) typeList.getSelectedItem();
				boolean available = true;

				for (int i = 0; i < users.size(); i++) {
					if (users.get(i).getUserName().equals(username)) {
						available = false;
					}
				}

				if (available == false) {
					JOptionPane.showMessageDialog(null, "Username already exists");
				} else {
					int reply = JOptionPane.showConfirmDialog(null, "Name: " + name + " Username: " + username
							+ " Password: " + password + " Type: " + userType, "Add User?", JOptionPane.YES_NO_OPTION);

					if (reply == JOptionPane.YES_OPTION) {
						if (userType.equals("Officer")) {
							users.add(new Officer(name, username, password));
						} else if (userType.equals("Voter")) {
							users.add(new Voter(name, username, password));
						}
					}
					frame.dispose();
				}

			}
		});

		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});

		frame.add(nameLabel);
		frame.add(nameText);
		frame.add(usernameLabel);
		frame.add(usernameText);
		frame.add(passwordLabel);
		frame.add(passwordText);
		frame.add(typeLabel);
		frame.add(typeList);
		frame.add(submitButton);
		frame.add(cancelButton);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	public static void DisplayUserGUI() {
		frame = new JFrame("USERS");
		frame.setSize(300, 150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(3, 2));

		String[] columnNames = { "Index", "Name", "Username", "Type" };

		Object[][] data = new Object[users.size()][4];

		for (int i = 1; i < users.size(); i++) {
			data[i][0] = i;
			data[i][1] = users.get(i).getName();
			data[i][2] = users.get(i).getUserName();
			if (users.get(i) instanceof Officer) {
				data[i][3] = "Officer";
			} else if (users.get(i) instanceof Voter) {
				data[i][3] = "Voter";
			}
		}

		JTable table = new JTable(data, columnNames);
		JScrollPane scrollPane = new JScrollPane(table);
		frame.add(scrollPane, BorderLayout.CENTER);

		JButton backButton = new JButton("Back");

		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});

		frame.add(backButton);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	public static void EditUserGUI() {
		frame = new JFrame("Edit User");
		frame.setSize(300, 150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(3, 2));

		JLabel usernameLabel = new JLabel("Username:");
		JTextField usernameText = new JTextField(20);

		JButton submitButton = new JButton("Submit");
		JButton cancelButton = new JButton("Cancel");

		DisplayUserGUI();

		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = usernameText.getText();
				int index = 0;
				for (int i = 0; i < users.size(); i++) {
					if (users.get(i).getUserName().equals(username)) {
						index = i;
					}
				}

				frame.dispose();

				if (index == 0) {
					JOptionPane.showMessageDialog(null, "Username not found");
				} else {
					EditUserGUI2(index);
				}
			}
		});

		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});

		frame.add(usernameLabel);
		frame.add(usernameText);
		frame.add(submitButton);
		frame.add(cancelButton);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	public static void EditUserGUI2(int index) {
		frame = new JFrame("Edit User");
		frame.setSize(300, 150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(3, 2));

		JLabel nameLabel = new JLabel("Name:");
		JLabel usernameLabel = new JLabel("Username:");
		JLabel passwordLabel = new JLabel("Password:");
		JLabel typeLabel = new JLabel("Type:");

		JTextField nameText = new JTextField(20);
		JTextField usernameText = new JTextField(20);
		JTextField passwordText = new JTextField(20);

		String[] type = { "Officer", "Voter" };
		JComboBox<Object> typeList = new JComboBox<Object>(type);

		JButton submitButton = new JButton("Submit");
		JButton cancelButton = new JButton("Cancel");

		nameText.setText(users.get(index).getName());
		usernameText.setText(users.get(index).getUserName());
		passwordText.setText(users.get(index).getPassword());
		if (users.get(index) instanceof Officer) {
			typeList.setSelectedIndex(0);
		} else if (users.get(index) instanceof Voter) {
			typeList.setSelectedIndex(1);
		}

		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = nameText.getText();
				String username = usernameText.getText();
				String password = passwordText.getText();
				String userType = (String) typeList.getSelectedItem();

				boolean sameUsername = false;

				if (users.get(index).getUserName().equals(username)) {
					sameUsername = true;
				}

				boolean usernameExists = false;

				for (int i = 0; i < users.size(); i++) {
					if (users.get(i).getUserName().equals(username)) {
						usernameExists = true;
					}
				}

				if (usernameExists && !sameUsername) {
					JOptionPane.showMessageDialog(null, "Username already exists");
					frame.dispose();
					return;
				}

				int reply = JOptionPane.showConfirmDialog(null,
						"Name: " + name + " Username: " + username + " Password: " + password + " Type: " + userType,
						"Edit User?", JOptionPane.YES_NO_OPTION);

				if (reply == JOptionPane.YES_OPTION) {
					if (userType.equals("Officer")) {
						users.set(index, new Officer(name, username, password));
					} else if (userType.equals("Voter")) {
						// Can we check if the user has voted before? If so, we have to set the voted
						// boolean to true

						if (users.get(index) instanceof Voter) {
							if (((Voter) users.get(index)).isVoted()) {
								users.set(index, new Voter(name, username, password, true));
							} else {
								users.set(index, new Voter(name, username, password));
							}
						} else {
							users.set(index, new Voter(name, username, password));
						}
					}
				}
				frame.dispose();
			}
		});

		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});

		frame.add(nameLabel);
		frame.add(nameText);
		frame.add(usernameLabel);
		frame.add(usernameText);
		frame.add(passwordLabel);
		frame.add(passwordText);
		frame.add(typeLabel);
		frame.add(typeList);
		frame.add(submitButton);
		frame.add(cancelButton);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	public static void RemoveUserGUI() {
		frame = new JFrame("Remove User");
		frame.setSize(300, 150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(3, 2));

		JLabel usernameLabel = new JLabel("Username:");
		JTextField usernameText = new JTextField(20);

		JButton submitButton = new JButton("Submit");
		JButton cancelButton = new JButton("Cancel");

		DisplayUserGUI();

		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = usernameText.getText();
				int index = 0;
				for (int i = 0; i < users.size(); i++) {
					if (users.get(i).getUserName().equals(username)) {
						index = i;
						int reply = JOptionPane.showConfirmDialog(null,
								"Name: " + users.get(index).getName() + " Username: " + users.get(index).getUserName()
										+ " Password: " + users.get(index).getPassword() + " Type: "
										+ users.get(index).getClass().getSimpleName(),
								"Remove User?", JOptionPane.YES_NO_OPTION);
						if (reply == JOptionPane.YES_OPTION) {
							users.remove(index);
						} else {
							frame.dispose();
						}
					}
				}
				frame.dispose();
			}
		});

		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});

		frame.add(usernameLabel);
		frame.add(usernameText);
		frame.add(submitButton);
		frame.add(cancelButton);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	public static void OfficerMenuGUI() {
		frame = new JFrame("Officer Menu");
		frame.setSize(300, 150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(3, 2));
		frame.setResizable(false);

		JButton addCandidateButton = new JButton("Add Candidate");
		JButton editCandidateButton = new JButton("Edit Candidate");
		JButton removeCandidateButton = new JButton("Remove Candidate");
		JButton displayCandidateButton = new JButton("Display Candidate");
		JButton voteSummaryButton = new JButton("Vote Summary");
		JButton logoutButton = new JButton("Logout");

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

		voteSummaryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// display vote summary form
				voteSummaryGUI();
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
		frame.add(voteSummaryButton);
		frame.add(logoutButton);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	// Time for Officer Menu Methods
	// Again the Candidate class is the super class for the President, Vice
	// President, and etc. classes
	// The Candidates class has the following attributes: name, votes (int), and
	// position (String)
	// The Candidates class has the following methods: getName(), getVotes(),
	// getPosition(), setName(String), setVotes(int), setPosition(String)
	// The Officer class or user can add, edit, and remove candidates.

	public static void addCandidate() {
		frame = new JFrame("Add Candidate");
		frame.setSize(300, 150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(3, 2));

		// Would it be better to make the position a drop down list? and then use a
		// switch statement to create the object? answer: yes

		JLabel nameLabel = new JLabel("Name:");
		JTextField nameText = new JTextField(20);
		// President, Vice President, Senators, District Representatives, Governors, and
		// Mayors.
		String[] positions = { "President", "Vice President", "Senator", "District Representative", "Governor",
				"Mayor" };
		JComboBox<Object> positionList = new JComboBox<Object>(positions);

		JButton submitButton = new JButton("Submit");
		JButton cancelButton = new JButton("Cancel");

		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = nameText.getText();
				String position = positionList.getSelectedItem().toString();

				// check position and add the correct candidate subclass object to the
				// candidates arraylist
				// Limits per postion (3) President, (3) Vice President, (10) Senators, (10)
				// District Representatives, (3) Governors, and (3) Mayors.
				// Would it be better to show a message dialog and say the candidates
				// information before adding it to the arraylist? answer: yes
				switch (position) {
				case "President":
					if (numPresident != 3) {

						int reply = JOptionPane.showConfirmDialog(null, "Name: " + name + " Position: " + position,
								"Add Candidate?", JOptionPane.YES_NO_OPTION);

						if (reply == JOptionPane.YES_OPTION) {
							candidates.add(new President(name, position));
							numPresident++;
						} else {
							frame.dispose();
						}
					} else {
						JOptionPane.showMessageDialog(null, "President limit reached");
					}
					break;
				case "Vice President":
					if (numVicePresident != 3) {
						int reply = JOptionPane.showConfirmDialog(null, "Name: " + name + " Position: " + position,
								"Add Candidate?", JOptionPane.YES_NO_OPTION);

						if (reply == JOptionPane.YES_OPTION) {
							candidates.add(new VicePresident(name, position));
							numVicePresident++;
						} else {
							frame.dispose();
						}
					} else {
						JOptionPane.showMessageDialog(null, "Vice President limit reached");
					}

					break;
				case "Senator":
					if (numSenator != 10) {
						int reply = JOptionPane.showConfirmDialog(null, "Name: " + name + " Position: " + position,
								"Add Candidate?", JOptionPane.YES_NO_OPTION);

						if (reply == JOptionPane.YES_OPTION) {
							candidates.add(new Senators(name, position));
							numSenator++;
						} else {
							frame.dispose();
						}
					} else {
						JOptionPane.showMessageDialog(null, "Senator limit reached");
					}
					break;
				case "District Representative":
					if (numDistrictRepresentative != 10) {
						int reply = JOptionPane.showConfirmDialog(null, "Name: " + name + " Position: " + position,
								"Add Candidate?", JOptionPane.YES_NO_OPTION);

						if (reply == JOptionPane.YES_OPTION) {
							candidates.add(new DistrictRepresentatives(name, position));
							numDistrictRepresentative++;
						} else {
							frame.dispose();
						}
					} else {
						JOptionPane.showMessageDialog(null, "District Representative limit reached");
					}
					break;
				case "Governor":
					if (numGovernor != 3) {
						int reply = JOptionPane.showConfirmDialog(null, "Name: " + name + " Position: " + position,
								"Add Candidate?", JOptionPane.YES_NO_OPTION);

						if (reply == JOptionPane.YES_OPTION) {
							candidates.add(new Governer(name, position));
							numGovernor++;
						} else {
							frame.dispose();
						}
					} else {
						JOptionPane.showMessageDialog(null, "Governor limit reached");
					}
					break;
				case "Mayor":
					if (numMayor != 3) {
						int reply = JOptionPane.showConfirmDialog(null, "Name: " + name + " Position: " + position,
								"Add Candidate?", JOptionPane.YES_NO_OPTION);

						if (reply == JOptionPane.YES_OPTION) {
							candidates.add(new Mayor(name, position));
							numMayor++;
						} else {
							frame.dispose();
						}
					} else {
						JOptionPane.showMessageDialog(null, "Mayor limit reached");
					}
					break;
				}

				frame.dispose();
			}
		});

		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});

		frame.add(nameLabel);
		frame.add(nameText);
		frame.add(positionList);
		frame.add(submitButton);
		frame.add(cancelButton);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	// Display Candidate GUI
	// There will be a big GUI table that will display all the candidates in the
	// system.
	// The table will have the following columns: Position, Name, Votes.
	// The table will be sorted by position.

	// Specifically from President, Vice President, Senators, District
	// Representatives, Governors, and Mayors.
	// Not necessarily sorted but grouped together.

	public static void DisplayCandidateGUI() {
		frame = new JFrame("Display Candidate");
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(2, 1));

		// create table
		String[] columnNames = { "Position", "Name", "Votes" };

		// It will use the Global candidates position counter to determine the size of
		// the array of the specific position.

		if (numPresident > 0) {
			Object[][] Pdata = new Object[numPresident][3];
			for (int i = 0; i < numPresident; i++) {
				Pdata[i][0] = candidates.get(i).getPosition();
				Pdata[i][1] = candidates.get(i).getName();
				Pdata[i][2] = candidates.get(i).getVotes();
			}

			// create table

			JTable table = new JTable(Pdata, columnNames);
			table.setPreferredScrollableViewportSize(new Dimension(500, 70));
			table.setFillsViewportHeight(true);
		}

		if (numVicePresident > 0) {
			Object[][] VPdata = new Object[numVicePresident][3];
			for (int i = 0; i < numVicePresident; i++) {
				VPdata[i][0] = candidates.get(i).getPosition();
				VPdata[i][1] = candidates.get(i).getName();
				VPdata[i][2] = candidates.get(i).getVotes();
			}

			// create table

			JTable table = new JTable(VPdata, columnNames);
			table.setPreferredScrollableViewportSize(new Dimension(500, 70));
			table.setFillsViewportHeight(true);
		}

		if (numSenator > 0) {
			Object[][] Sdata = new Object[numSenator][3];
			for (int i = 0; i < numSenator; i++) {
				Sdata[i][0] = candidates.get(i).getPosition();
				Sdata[i][1] = candidates.get(i).getName();
				Sdata[i][2] = candidates.get(i).getVotes();
			}

			// create table

			JTable table = new JTable(Sdata, columnNames);
			table.setPreferredScrollableViewportSize(new Dimension(500, 70));
			table.setFillsViewportHeight(true);
		}

		if (numDistrictRepresentative > 0) {
			Object[][] DRdata = new Object[numDistrictRepresentative][3];
			for (int i = 0; i < numDistrictRepresentative; i++) {
				DRdata[i][0] = candidates.get(i).getPosition();
				DRdata[i][1] = candidates.get(i).getName();
				DRdata[i][2] = candidates.get(i).getVotes();
			}

			// create table

			JTable table = new JTable(DRdata, columnNames);
			table.setPreferredScrollableViewportSize(new Dimension(500, 70));
			table.setFillsViewportHeight(true);

		}

		if (numGovernor > 0) {
			Object[][] Gdata = new Object[numGovernor][3];
			for (int i = 0; i < numGovernor; i++) {
				Gdata[i][0] = candidates.get(i).getPosition();
				Gdata[i][1] = candidates.get(i).getName();
				Gdata[i][2] = candidates.get(i).getVotes();
			}

			// create table

			JTable table = new JTable(Gdata, columnNames);
			table.setPreferredScrollableViewportSize(new Dimension(500, 70));
			table.setFillsViewportHeight(true);

		}

		if (numMayor > 0) {
			Object[][] Mdata = new Object[numMayor][3];
			for (int i = 0; i < numMayor; i++) {
				Mdata[i][0] = candidates.get(i).getPosition();
				Mdata[i][1] = candidates.get(i).getName();
				Mdata[i][2] = candidates.get(i).getVotes();
			}

			// create table

			JTable table = new JTable(Mdata, columnNames);
			table.setPreferredScrollableViewportSize(new Dimension(500, 70));
			table.setFillsViewportHeight(true);

		}

		if (numPresident == 0 && numVicePresident == 0 && numSenator == 0 && numDistrictRepresentative == 0
				&& numGovernor == 0 && numMayor == 0) {
			// Just show a message that there are no candidates.
			JOptionPane.showMessageDialog(null, "There are no candidates");
			frame.dispose();
		}
		// JScrollPane scrollPane = new JScrollPane(table);
		// frame.add(scrollPane);

		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});

		frame.add(backButton);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	// I think its best if its just the index of the user in the arraylist
	public static void VoterMenuGUI(int index) {
		frame = new JFrame("Voter Menu");
		frame.setSize(300, 150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(3, 2));
		frame.setResizable(false);

		// Ceate a popup that says you have already voted if the voter has already voted
		// Create a popup that says the candidate list is not yet ready if the candidate
		// list is not full or candidateFull() returns false

		if (((Voter) users.get(index)).isVoted()) {
			// cant it be a message dialog?
			JOptionPane.showMessageDialog(null, "You have already voted");
		}

		if (!candidateFull()) {
			JOptionPane.showMessageDialog(null, "The candidate list is not yet ready");
		}

		if (!((Voter) users.get(index)).isVoted() && candidateFull()) {
			JButton voteButton = new JButton("Vote");
			voteButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// display vote form
					// VoteGUI();
				}
			});
			frame.add(voteButton);
		}

		JButton displayCandidateButton = new JButton("Display Candidate");
		JButton logoutButton = new JButton("Logout");
		// add a button for displaying the results that is only visible if the voter has
		// voted

		if (((Voter) users.get(index)).isVoted()) {
			JButton displayResultsButton = new JButton("Display Results");
			displayResultsButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// display results form
					// DisplayResultsGUI();
				}
			});
			frame.add(displayResultsButton);
		}

		displayCandidateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// display display candidate form
				// DisplayCandidateGUI();
			}
		});

		logoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// display login form
				// LoginGUI();
			}
		});

		frame.add(displayCandidateButton);
		frame.add(logoutButton);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
