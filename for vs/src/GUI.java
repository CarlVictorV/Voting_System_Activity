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

public class GUI extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static JFrame frame;
	public static JLabel userLabel;
	public static JLabel passwordLabel;
	public static JTextField userText;
	public static JPasswordField passwordText;
	public static JButton loginButton;
	public static JButton cancelButton;
	public static JLabel success;
	public static JLabel label;

	protected static ArrayList<User> users;
	protected static ArrayList<Candidates> candidates;

	public GUI(ArrayList<User> users, ArrayList<Candidates> candidates) {
		GUI.users = users;
		GUI.candidates = candidates;
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

						if (users.get(i) instanceof Superuser) {
							frame.dispose();
							SuperGUI.SuperUserMenuGUI();
						} else if (users.get(i) instanceof Officer) {
							frame.dispose();
							OfficerGUI.OfficerMenuGUI();
						} else if (users.get(i) instanceof Voter) {
							frame.dispose();
							VoterGUI.VoterMenuGUI(i);
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

	public static void voteSummaryGUI(int index) {// This is the last GUI to be added
		frame = new JFrame("Vote Summary");
		frame.setSize(300, 150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(3, 2));

		String[] columnNames = { "Position", "Name", "Votes" };

		Object[][] data = new Object[candidates.size()][3];

		for (int i = 0; i < candidates.size(); i++) {
			data[i][1] = candidates.get(i).getName();
			data[i][0] = candidates.get(i).getPosition();
			data[i][2] = candidates.get(i).getVotes();
		}

		JTable table = new JTable(data, columnNames);
		JScrollPane scrollPane = new JScrollPane(table);
		frame.add(scrollPane, BorderLayout.CENTER);

		JButton backButton = new JButton("Back");

		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				if (index > 0) {
					VoterGUI.VoterMenuGUI(index);
				} else if (index == -1) {
					SuperGUI.SuperUserMenuGUI();
				} else {
					OfficerGUI.OfficerMenuGUI();
				}

			}
		});

		frame.add(backButton);
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
				VoterGUI.VoterMenuGUI(index);
			}
		});

		frame.add(backButton);
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
				OfficerGUI.OfficerMenuGUI();
			}
		});

		frame.add(backButton);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	public static int numPresident = 0;
	public static int numVicePresident = 0;
	public static int numSenator = 0;
	public static int numDistrictRepresentative = 0;
	public static int numGovernor = 0;
	public static int numMayor = 0;
	public static int numVoterVoted = 0;

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
}
