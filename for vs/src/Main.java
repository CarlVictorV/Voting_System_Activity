import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;

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
	static ArrayList<User> users = new ArrayList<User>();
	static ArrayList<Candidates> candidates = new ArrayList<Candidates>();
	public static Scanner input = new Scanner(System.in);
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

		LoginGUI();

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
		users.add(new Voter("Voter", "c", "c"));
		users.add(new Voter("Voter", "cc", "cc", true));

		// Add candidates
		candidates.add(new President("President", "a", 0));
		candidates.add(new President("President", "b", 0));
		candidates.add(new President("President", "c", 0));

		candidates.add(new VicePresident("Vice President", "a", 0));
		candidates.add(new VicePresident("Vice President", "b", 0));
		candidates.add(new VicePresident("Vice President", "c", 0));

		candidates.add(new Senators("Senator", "a", 0));
		candidates.add(new Senators("Senator", "b", 0));
		candidates.add(new Senators("Senator", "c", 0));
		candidates.add(new Senators("Senator", "d", 0));
		candidates.add(new Senators("Senator", "e", 0));
		candidates.add(new Senators("Senator", "f", 0));
		candidates.add(new Senators("Senator", "g", 0));
		candidates.add(new Senators("Senator", "h", 0));
		candidates.add(new Senators("Senator", "i", 0));
		candidates.add(new Senators("Senator", "j", 0));

		candidates.add(new DistrictRepresentatives("District Representative", "a", 0));
		candidates.add(new DistrictRepresentatives("District Representative", "b", 0));
		candidates.add(new DistrictRepresentatives("District Representative", "c", 0));
		candidates.add(new DistrictRepresentatives("District Representative", "d", 0));
		candidates.add(new DistrictRepresentatives("District Representative", "e", 0));
		candidates.add(new DistrictRepresentatives("District Representative", "f", 0));
		candidates.add(new DistrictRepresentatives("District Representative", "g", 0));
		candidates.add(new DistrictRepresentatives("District Representative", "h", 0));
		candidates.add(new DistrictRepresentatives("District Representative", "i", 0));
		candidates.add(new DistrictRepresentatives("District Representative", "j", 0));

		candidates.add(new Governer("Governor", "a", 0));
		candidates.add(new Governer("Governor", "b", 0));
		candidates.add(new Governer("Governor", "c", 0));

		candidates.add(new Mayor("Mayor", "a", 0));
		candidates.add(new Mayor("Mayor", "b", 0));
		candidates.add(new Mayor("Mayor", "c", 0));

		// Set all number of candidates to max

		numPresident = 3;
		numVicePresident = 3;
		numSenator = 10;
		numDistrictRepresentative = 10;
		numGovernor = 3;
		numMayor = 3;

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
				frame.dispose();
				AddUserGUI();
			}
		});

		editUserButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// display edit user form
				frame.dispose();
				EditUserGUI();
			}
		});

		removeUserButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// display remove user form
				frame.dispose();
				RemoveUserGUI();
			}
		});

		displayUserButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// display display user form
				frame.dispose();
				DisplayUserGUI();
			}
		});

		voteSummaryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (candidateVoted() == true) {
					// display vote summary form
					frame.dispose();
					voteSummaryGUI();
				} else {
					JOptionPane.showMessageDialog(null, "No candidate has been voted yet");
				}
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
				}

				frame.dispose();
				SuperUserMenuGUI();

			}
		});

		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				SuperUserMenuGUI();
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
				SuperUserMenuGUI();
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

				if (index == 0) {
					if (users.get(index).getUserName().equals(username)) {
						JOptionPane.showMessageDialog(null, "Cannot edit super user");
					} else {
						JOptionPane.showMessageDialog(null, "Username does not exist");
					}
					frame.dispose();
					SuperUserMenuGUI();
				} else {

					// if user is an voter and is already voted yet then pop up a message saying
					// that the user has voted.
					if (users.get(index) instanceof Voter) {
						if (((Voter) users.get(index)).isVoted() == true) {
							JOptionPane.showMessageDialog(null, "User has already voted");
							// return to the officer menu
							frame.dispose();
							SuperUserMenuGUI();
						} else {
							frame.dispose();
							EditUserGUI2(index);
						}
					} else {
						frame.dispose();
						EditUserGUI2(index);
					}
				}

			}
		});

		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				SuperUserMenuGUI();
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
					SuperUserMenuGUI();
				}

				int reply = JOptionPane.showConfirmDialog(null,
						"Name: " + name + " Username: " + username + " Password: " + password + " Type: " + userType,
						"Edit User?", JOptionPane.YES_NO_OPTION);

				if (reply == JOptionPane.YES_OPTION) {
					if (userType.equals("Officer")) {
						users.set(index, new Officer(name, username, password));
					} else if (userType.equals("Voter")) {

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
				SuperUserMenuGUI();
			}
		});

		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				SuperUserMenuGUI();
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

						// Create checker to see if the user has voted

						if (users.get(index) instanceof Voter) {
							if (((Voter) users.get(index)).isVoted()) {
								JOptionPane.showMessageDialog(null, "User has already voted");
								frame.dispose();
								SuperUserMenuGUI();
								return;
							}
						} else if (users.get(index) instanceof Superuser) {
							JOptionPane.showMessageDialog(null, "Cannot remove Yourself!");
							frame.dispose();
							SuperUserMenuGUI();
							return;
						}
						// add an else if for superuser, and if the user is a superuser, don't let them
						// remove themselves

						int reply = JOptionPane.showConfirmDialog(null,
								"Name: " + users.get(index).getName() + " Username: " + users.get(index).getUserName()
										+ " Password: " + users.get(index).getPassword() + " Type: "
										+ users.get(index).getClass().getSimpleName(),
								"Remove User?", JOptionPane.YES_NO_OPTION);
						if (reply == JOptionPane.YES_OPTION) {
							users.remove(index);
							JOptionPane.showMessageDialog(null, "User Removed");
							frame.dispose();
							SuperUserMenuGUI();
						} else {
							frame.dispose();
							SuperUserMenuGUI();
						}
					}
				}

				// Create a message that user does not exist

				JOptionPane.showMessageDialog(null, "User does not exist");

				frame.dispose();
				SuperUserMenuGUI();
			}
		});

		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				SuperUserMenuGUI();
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

				if (candidateFull()) {
					JOptionPane.showMessageDialog(null, "Candidate list is full");
				} else {
					frame.dispose();
					addCandidate();
				}
			}
		});

		editCandidateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (candidateVoted()) {
					JOptionPane.showMessageDialog(null, "Voting has started");
				} else {
					frame.dispose();
					candidateEditGUI();
				}
			}
		});

		removeCandidateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (candidateVoted()) {
					JOptionPane.showMessageDialog(null, "Voting has started");
				} else {
					frame.dispose();
					removeCandidateGUI();
				}
			}
		});

		displayCandidateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				DisplayCandidateGUI();
			}
		});

		voteSummaryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (candidateVoted() == false) {
					JOptionPane.showMessageDialog(null, "Voting has not started");
				} else {
					frame.dispose();
					voteSummaryGUI();
				}
			}
		});

		logoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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

	public static void addCandidate() {
		frame = new JFrame("Add Candidate");
		frame.setSize(300, 150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(3, 2));
		JLabel nameLabel = new JLabel("Name:");
		JTextField nameText = new JTextField(20);
		String[] positions = { "President", "Vice President", "Senator", "District Representative", "Governor",
				"Mayor" };
		JComboBox<Object> positionList = new JComboBox<Object>(positions);

		JButton submitButton = new JButton("Submit");
		JButton cancelButton = new JButton("Cancel");

		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = nameText.getText();
				String position = positionList.getSelectedItem().toString();
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
							OfficerMenuGUI();
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
							OfficerMenuGUI();
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
							OfficerMenuGUI();
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
							OfficerMenuGUI();
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
							OfficerMenuGUI();
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
							OfficerMenuGUI();
						}
					} else {
						JOptionPane.showMessageDialog(null, "Mayor limit reached");
					}
					break;
				}

				frame.dispose();
				OfficerMenuGUI();
			}
		});

		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				OfficerMenuGUI();
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

	public static void DisplayCandidateGUI() {
		frame = new JFrame("Display Candidate");
		frame.setSize(300, 150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(3, 2));

		String[] columnNames = { "Position", "Name" };

		Object[][] data = new Object[candidates.size()][2];

		for (int i = 0; i < candidates.size(); i++) {
			data[i][1] = candidates.get(i).getName();
			data[i][0] = candidates.get(i).getPosition();
		}

		JTable table = new JTable(data, columnNames);
		JScrollPane scrollPane = new JScrollPane(table);
		frame.add(scrollPane, BorderLayout.CENTER);

		JButton backButton = new JButton("Back");

		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				OfficerMenuGUI();
			}
		});

		frame.add(backButton);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	public static void candidateEditGUI()// Purpose: To edit the candidates name and position
	{
		frame = new JFrame("Edit Candidates");
		frame.setSize(300, 150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(3, 2));
		frame.setResizable(false);

		JLabel nameLabel = new JLabel("Name:");
		JTextField nameText = new JTextField(20);
		JButton submitButton = new JButton("Submit");
		JButton cancelButton = new JButton("Cancel");

		DisplayCandidateGUI();

		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = nameText.getText();

				int index = -1;

				for (int i = 0; i < candidates.size(); i++) {
					if (candidates.get(i).getName().equals(name)) {
						index = i;
					}
				}

				if (index == -1) {
					JOptionPane.showMessageDialog(null, "Candidate not found");
				} else {
					frame.dispose();
					candidateEditGUI2(index);
				}
			}
		});

		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				OfficerMenuGUI();
			}
		});

		frame.add(nameLabel);
		frame.add(nameText);
		frame.add(submitButton);
		frame.add(cancelButton);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	public static void candidateEditGUI2(int index) {
		frame = new JFrame("Edit Candidates");
		frame.setSize(300, 150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(3, 2));
		frame.setResizable(false);

		JLabel nameLabel = new JLabel("Name:");
		JTextField nameText = new JTextField(20);
		String[] positions = { "President", "Vice President", "Senator", "District Representative", "Governor",
				"Mayor" };
		JComboBox<Object> positionList = new JComboBox<Object>(positions);
		JButton submitButton = new JButton("Submit");
		JButton cancelButton = new JButton("Cancel");

		nameText.setText(candidates.get(index).getName());

		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = nameText.getText();
				String position = (String) positionList.getSelectedItem();

				// Create a boolean to check if the position is valid, is the same as the
				// original position, or if the new position is full.

				boolean valid = false;
				boolean same = false;
				boolean full = false;

				for (int i = 0; i < positions.length; i++) {
					if (position.equals(positions[i])) {
						valid = true;
					}
				}

				if (position.equals(candidates.get(index).getPosition())) {
					same = true;
				}
				// (3) President, (3) Vice President, (10) Senators, (10) District
				// Representatives, (3) Governors, and (3) Mayors.
				switch (position) {
				case "President":
					if (numPresident < 3) {
						numPresident++;
					} else {
						full = true;
					}
					break;
				case "Vice President":
					if (numVicePresident < 3) {
						numVicePresident++;
					} else {
						full = true;
					}
					break;
				case "Senator":
					if (numSenator < 10) {
						numSenator++;
					} else {
						full = true;
					}
					break;
				case "District Representative":
					if (numDistrictRepresentative < 10) {
						numDistrictRepresentative++;
					} else {
						full = true;
					}
					break;
				case "Governor":
					if (numGovernor < 3) {
						numGovernor++;
					} else {
						full = true;
					}
					break;
				case "Mayor":
					if (numMayor < 3) {
						numMayor++;
					} else {
						full = true;
					}
					break;
				}

				if (valid == false) {
					JOptionPane.showMessageDialog(null, "Position is not valid");
				} else if (same == true) {
					int reply = JOptionPane.showConfirmDialog(null,
							"Are you sure you want to edit the candidate's name?\n"
									+ "This will change the candidate's name to " + name,
							"Edit Candidate", JOptionPane.YES_NO_OPTION);
					if (reply == JOptionPane.YES_OPTION) {
						candidates.get(index).setName(name);
						JOptionPane.showMessageDialog(null, "Candidate edited");
						frame.dispose();
						OfficerMenuGUI();
					} else {
						frame.dispose();
						OfficerMenuGUI();
					}
				} else if (full == true) {
					JOptionPane.showMessageDialog(null, "Position is full");
					frame.dispose();
					OfficerMenuGUI();
				} else {
					// I prefer showwing the name of the candidate and the position they are
					// swapping with.
					int reply = JOptionPane.showConfirmDialog(null,
							"Are you sure you want to edit the candidate's name and position?\n"
									+ "This will swap the candidate with " + candidates.get(index).getName()
									+ " who is running for " + candidates.get(index).getPosition(),
							"Edit Candidate", JOptionPane.YES_NO_OPTION);
					if (reply == JOptionPane.YES_OPTION) {
						switch (candidates.get(index).getPosition()) {
						case "President":
							numPresident--;
							break;
						case "Vice President":
							numVicePresident--;
							break;
						case "Senator":
							numSenator--;
							break;
						case "District Representative":
							numDistrictRepresentative--;
							break;
						case "Governor":
							numGovernor--;
							break;
						case "Mayor":
							numMayor--;
							break;
						}
						switch (position) {
						case "President":
							candidates.set(index, new President(name, position));
							break;
						case "Vice President":
							candidates.set(index, new VicePresident(name, position));
							break;
						case "Senator":
							candidates.set(index, new Senators(name, position));
							break;
						case "District Representative":
							candidates.set(index, new DistrictRepresentatives(name, position));
							break;
						case "Governor":
							candidates.set(index, new Governer(name, position));
							break;
						case "Mayor":
							candidates.set(index, new Mayor(name, position));
							break;
						}
						JOptionPane.showMessageDialog(null, "Candidate edited");
						frame.dispose();
						OfficerMenuGUI();
					} else {
						frame.dispose();
						OfficerMenuGUI();
					}
				}
			}
		});

		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				OfficerMenuGUI();
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

	public static void removeCandidateGUI() {
		frame = new JFrame("Remove Candidates");
		frame.setSize(300, 150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(3, 2));
		frame.setResizable(false);

		JLabel nameLabel = new JLabel("Name:");
		JTextField nameText = new JTextField(20);
		JButton submitButton = new JButton("Submit");
		JButton cancelButton = new JButton("Cancel");

		DisplayCandidateGUI();

		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = nameText.getText();

				int index = -1;

				for (int i = 0; i < candidates.size(); i++) {
					if (candidates.get(i).getName().equals(name)) {
						index = i;
					}
				}

				if (index == -1) {
					JOptionPane.showMessageDialog(null, "Candidate does not exist");
					frame.dispose();
					OfficerMenuGUI();
				} else {
					int reply = JOptionPane.showConfirmDialog(null, "Name: " + name, "Remove Candidate?",
							JOptionPane.YES_NO_OPTION);
					if (reply == JOptionPane.YES_OPTION) {

						String position = candidates.get(index).getPosition();
						switch (position) {
						case "President":
							numPresident--;
							break;
						case "Vice President":
							numVicePresident--;
							break;
						case "Senator":
							numSenator--;
							break;
						case "District Representative":
							numDistrictRepresentative--;
							break;
						case "Governor":
							numGovernor--;
							break;
						case "Mayor":
							numMayor--;
							break;
						}
					}
				}
				candidates.remove(index);
				frame.dispose();
				OfficerMenuGUI();
			}
		});

		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				OfficerMenuGUI();
			}
		});

		frame.add(nameLabel);
		frame.add(nameText);
		frame.add(submitButton);
		frame.add(cancelButton);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	public static void VoterMenuGUI(int index) {
		frame = new JFrame("Voter Menu");
		frame.setSize(300, 150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(3, 2));
		frame.setResizable(false);

		boolean voted = ((Voter) users.get(index)).isVoted();

		if (voted) {
			JOptionPane.showMessageDialog(null, "You have already voted");
		}

		if (!candidateFull()) {
			JOptionPane.showMessageDialog(null, "The candidate list is not yet ready");
		}

		if (!voted && candidateFull()) {
			JButton voteButton = new JButton("Vote");
			voteButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// display vote form
					VoteGUI(index);
				}
			});
			frame.add(voteButton);
		}

		JButton displayCandidateButton = new JButton("Display Candidate");
		JButton logoutButton = new JButton("Logout");

		if (voted) {
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
				frame.dispose();
				DisplayCandidateGUI(index);
			}
		});

		logoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				LoginGUI();
			}
		});

		frame.add(displayCandidateButton);
		frame.add(logoutButton);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	public static void DisplayCandidateGUI(int index) {
		frame = new JFrame("Display Candidate");
		frame.setSize(300, 150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(3, 2));

		String[] columnNames = { "Position", "Name" };

		Object[][] data = new Object[candidates.size()][2];

		for (int i = 0; i < candidates.size(); i++) {
			data[i][1] = candidates.get(i).getName();
			data[i][0] = candidates.get(i).getPosition();
		}

		JTable table = new JTable(data, columnNames);
		JScrollPane scrollPane = new JScrollPane(table);
		frame.add(scrollPane, BorderLayout.CENTER);

		JButton backButton = new JButton("Back");

		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				VoterMenuGUI(index);
			}
		});

		frame.add(backButton);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	/*
	 * VOTING SYSTEM
	 * 
	 * Please select one (1) candidate for President:
	 * ---------------------------------------------- [ ] President 1 [ ] President
	 * 2 [ ] President 3
	 * 
	 * Please select one (1) candidate for Vice President:
	 * --------------------------------------------------- [ ] Vice President 1 [ ]
	 * Vice President 2 [ ] Vice President 3
	 * 
	 * Please select up to five (5) candidates for Senator:
	 * ---------------------------------------------------- [ ] Senator 1 [ ]
	 * Senator 2 [ ] Senator 3 [ ] Senator 4 [ ] Senator 5 [ ] Senator 6 [ ] Senator
	 * 7 [ ] Senator 8 [ ] Senator 9 [ ] Senator 10
	 * 
	 * Please select up to four (4) candidates for District Representative:
	 * -------------------------------------------------------------------- [ ]
	 * District Representative 1 [ ] District Representative 2 [ ] District
	 * Representative 3 [ ] District Representative 4 [ ] District Representative 5
	 * [ ] District Representative 6 [ ] District Representative 7 [ ] District
	 * Representative 8 [ ] District Representative 9 [ ] District Representative 10
	 * 
	 * Please select one (1) candidate for Governor:
	 * --------------------------------------------- [ ] Governor 1 [ ] Governor 2 [
	 * ] Governor 3
	 * 
	 * Please select one (1) candidate for Mayor:
	 * ------------------------------------------- [ ] Mayor 1 [ ] Mayor 2 [ ] Mayor
	 * 3
	 * 
	 * [SUBMIT] [CANCEL]
	 * 
	 */

	// The above is the GUI for the voting system. The GUI should be displayed
	// after the voter has logged in and clicked the "Vote" button.
	// The voter can only vote once. If the voter has already voted, the "Vote"
	// button disappears.
	// If the candidate list is not yet ready, the "Vote" button disappears.
	// The voter can only vote if the candidate list is ready.
	// The voter can only vote for this number of candidates: President - 1, Vice
	// President - 1, Senator - 5, District Representative - 4, Governor - 1, Mayor
	// - 1.
	// The voter can only vote for candidates of the same position once. For
	// example, the voter can only vote for one (1) candidate for President but can
	// vote for (5) candidates for Senator and (4) candidates for District
	// Representative.

	public static void VoteGUI(int index) {
		// Time to vote
		frame = new JFrame("Vote");
		frame.setSize(500, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		JScrollPane scroll = new JScrollPane(panel);

		// Create the check boxes.
		JCheckBox[] president = new JCheckBox[3];
		president[0] = new JCheckBox("President 1");
		president[1] = new JCheckBox("President 2");
		president[2] = new JCheckBox("President 3");

		JCheckBox[] vicePresident = new JCheckBox[3];
		vicePresident[0] = new JCheckBox("Vice President 1");
		vicePresident[1] = new JCheckBox("Vice President 2");
		vicePresident[2] = new JCheckBox("Vice President 3");

		JCheckBox[] senator = new JCheckBox[10];
		senator[0] = new JCheckBox("Senator 1");
		senator[1] = new JCheckBox("Senator 2");
		senator[2] = new JCheckBox("Senator 3");
		senator[3] = new JCheckBox("Senator 4");
		senator[4] = new JCheckBox("Senator 5");
		senator[5] = new JCheckBox("Senator 6");
		senator[6] = new JCheckBox("Senator 7");
		senator[7] = new JCheckBox("Senator 8");
		senator[8] = new JCheckBox("Senator 9");
		senator[9] = new JCheckBox("Senator 10");

		JCheckBox[] districtRepresentative = new JCheckBox[10];
		districtRepresentative[0] = new JCheckBox("District Representative 1");
		districtRepresentative[1] = new JCheckBox("District Representative 2");
		districtRepresentative[2] = new JCheckBox("District Representative 3");
		districtRepresentative[3] = new JCheckBox("District Representative 4");
		districtRepresentative[4] = new JCheckBox("District Representative 5");
		districtRepresentative[5] = new JCheckBox("District Representative 6");
		districtRepresentative[6] = new JCheckBox("District Representative 7");
		districtRepresentative[7] = new JCheckBox("District Representative 8");
		districtRepresentative[8] = new JCheckBox("District Representative 9");
		districtRepresentative[9] = new JCheckBox("District Representative 10");

		JCheckBox[] governor = new JCheckBox[3];
		governor[0] = new JCheckBox("Governor 1");
		governor[1] = new JCheckBox("Governor 2");
		governor[2] = new JCheckBox("Governor 3");

		JCheckBox[] mayor = new JCheckBox[3];
		mayor[0] = new JCheckBox("Mayor 1");
		mayor[1] = new JCheckBox("Mayor 2");
		mayor[2] = new JCheckBox("Mayor 3");

		// Add the check boxes to the panel.
		panel.add(new JLabel("President"));
		for (int i = 0; i < president.length; i++) {
			panel.add(president[i]);
		}

		panel.add(new JLabel("Vice President"));
		for (int i = 0; i < vicePresident.length; i++) {
			panel.add(vicePresident[i]);
		}

		panel.add(new JLabel("Senator"));
		for (int i = 0; i < senator.length; i++) {
			panel.add(senator[i]);
		}

		panel.add(new JLabel("District Representative"));
		for (int i = 0; i < districtRepresentative.length; i++) {
			panel.add(districtRepresentative[i]);
		}

		panel.add(new JLabel("Governor"));
		for (int i = 0; i < governor.length; i++) {
			panel.add(governor[i]);
		}

		panel.add(new JLabel("Mayor"));
		for (int i = 0; i < mayor.length; i++) {
			panel.add(mayor[i]);
		}

		// Create the submit and cancel buttons.
		JButton submit = new JButton("Submit");
		JButton cancel = new JButton("Cancel");

		// Add the buttons to the panel.
		panel.add(submit);
		panel.add(cancel);

		// Add the panel to the frame.
		frame.add(scroll);

		// Display the frame.
		frame.setVisible(true);

		// Add the action listeners to the buttons.
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Check if the voter has voted for the president.
				int count = 0;
				for (int i = 0; i < president.length; i++) {
					if (president[i].isSelected()) {
						count++;
					}
				}
				if (count != 1) {
					JOptionPane.showMessageDialog(null, "Please select one (1) candidate for President.");
					return;
				}

				// Check if the voter has voted for the vice president.
				count = 0;
				for (int i = 0; i < vicePresident.length; i++) {
					if (vicePresident[i].isSelected()) {
						count++;
					}
				}
				if (count != 1) {
					JOptionPane.showMessageDialog(null, "Please select one (1) candidate for Vice President.");
					return;
				}

				// Check if the voter has voted for the senator.
				count = 0;
				for (int i = 0; i < senator.length; i++) {
					if (senator[i].isSelected()) {
						count++;
					}
				}
				if (count != 5) {
					JOptionPane.showMessageDialog(null, "Please select five (5) candidates for Senator.");
					return;
				}

				// Check if the voter has voted for the district representative.
				count = 0;
				for (int i = 0; i < districtRepresentative.length; i++) {
					if (districtRepresentative[i].isSelected()) {
						count++;
					}
				}
				if (count != 4) {
					JOptionPane.showMessageDialog(null,
							"Please select four (4) candidates for District Representative.");
					return;
				}

				// Check if the voter has voted for the governor.
				count = 0;
				for (int i = 0; i < governor.length; i++) {
					if (governor[i].isSelected()) {
						count++;
					}
				}
				if (count != 1) {
					JOptionPane.showMessageDialog(null, "Please select one (1) candidate for Governor.");
					return;
				}

				// Check if the voter has voted for the mayor.
				count = 0;
				for (int i = 0; i < mayor.length; i++) {
					if (mayor[i].isSelected()) {
						count++;
					}
				}
				if (count != 1) {
					JOptionPane.showMessageDialog(null, "Please select one (1) candidate for Mayor.");
					return;
				}

				// If the voter has voted for all the candidates, display a message.
				JOptionPane.showMessageDialog(null, "Thank you for voting!");

				// Close the frame.
				frame.dispose();

				// Open the voter menu.
				VoterMenuGUI(index);

			}

		});

		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Close the frame.
				frame.dispose();

				// Open the voter menu.
				VoterMenuGUI(index);
			}
		});

	}
}
