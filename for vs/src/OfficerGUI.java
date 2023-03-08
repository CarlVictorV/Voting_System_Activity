import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class OfficerGUI extends GUI {

	public OfficerGUI(ArrayList<User> users, ArrayList<Candidates> candidates) {
		super(users, candidates);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
					voteSummaryGUI(-3);
				}
			}
		});

		logoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				GUI.LoginGUI();
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

				//Make sure the name is not empty and the name isn't already in the list
				if (name.equals("")) {
					JOptionPane.showMessageDialog(null, "Name cannot be empty");
				} else if (nameExists(name)) {
					JOptionPane.showMessageDialog(null, "Name already exists");
				} else {
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
						if (numDistrictRep != 10) {
							int reply = JOptionPane.showConfirmDialog(null, "Name: " + name + " Position: " + position,
									"Add Candidate?", JOptionPane.YES_NO_OPTION);

							if (reply == JOptionPane.YES_OPTION) {
								candidates.add(new DistrictRepresentative(name, position));
								numDistrictRep++;
							} else {
								frame.dispose();
								OfficerMenuGUI();
							}
						} else {
							JOptionPane.showMessageDialog(null, "District Representative limit reached");
						}
						break;
					case "Governor":
						if (numGovernor != 1) {
							int reply = JOptionPane.showConfirmDialog(null, "Name: " + name + " Position: " + position,
									"Add Candidate?", JOptionPane.YES_NO_OPTION);

							if (reply == JOptionPane.YES_OPTION) {
								candidates.add(new Governor(name, position));
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
						if (numMayor != 1) {
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

	public static void candidateEditGUI() {
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
}