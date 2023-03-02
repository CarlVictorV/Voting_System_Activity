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
		users.add(new Voter("Voter", "voter", "voter"));
		users.add(new Voter("Voter", "cc", "cc", true));

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

	public static void candidateEditGUI() {
		frame.setSize(300, 150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(3, 2));

		JLabel usernameLabel = new JLabel("Name:");
		JTextField usernameText = new JTextField(20);

		JButton submitButton = new JButton("Submit");
		JButton cancelButton = new JButton("Cancel");

		DisplayCandidateGUI();

		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = usernameText.getText();
				int index = -1;
				for (int i = 0; i < candidates.size(); i++) {
					if (candidates.get(i).getName().equals(username)) {
						index = i;
					}
				}

				if (index == -1) {
					JOptionPane.showMessageDialog(null, "Candidate does not exist");
					frame.dispose();
					OfficerMenuGUI();
				} else {
					frame.dispose();

					candyEditGUI2(index);
				}

			}
		});

		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				OfficerMenuGUI();
			}
		});

		frame.add(usernameLabel);
		frame.add(usernameText);
		frame.add(submitButton);
		frame.add(cancelButton);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	public static void candyEditGUI2(int index) {
		frame = new JFrame("Edit Candidates");
		frame.setSize(300, 150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(3, 2));
		JLabel nameLabel = new JLabel("Name:");
		JTextField nameText = new JTextField(20);
		JButton submitButton = new JButton("Submit");
		JButton cancelButton = new JButton("Cancel");

		nameText.setText(candidates.get(index).getName());

		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = nameText.getText();

				int reply = JOptionPane.showConfirmDialog(null, "Name: " + name, "Edit Candidate?",
						JOptionPane.YES_NO_OPTION);

				if (reply == JOptionPane.YES_OPTION) {

					String position = candidates.get(index).getPosition();
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
		frame.add(submitButton);
		frame.add(cancelButton);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	public static void removeCandidateGUI() {
		frame.setSize(300, 150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(3, 2));

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

		if (voted && candidateFull()) {
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



	public static void VoteGUI(int index)
	{
		frame = new JFrame("Vote ");
		frame.setSize(300, 150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(3, 2));
	}
}

