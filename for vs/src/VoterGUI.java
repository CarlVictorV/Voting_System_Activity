public class VoterGUI extends GUI{

        // Voter Menu
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
					frame.dispose();
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
					frame.dispose();
					voteSummaryGUI(index);
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

	public static void VoteGUI(int index) {
		// Time to vote
		frame = new JFrame("Vote");
		frame.setSize(500, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		JScrollPane scroll = new JScrollPane(panel);

		Object[][] data = new Object[candidates.size()][2];
		int pres = 0, vp = 3, sen = 6, dist = 16, gov = 26, may = 29;

		for (int i = 0; i < 32; i++) {
			String position = candidates.get(i).getPosition();

			switch (position) {
			case "President":
				data[pres][1] = candidates.get(i).getName();
				data[pres][0] = i;
				pres++;
				break;
			case "Vice President":
				data[vp][1] = candidates.get(i).getName();
				data[vp][0] = i;
				vp++;
				break;
			case "Senator":
				data[sen][1] = candidates.get(i).getName();
				data[sen][0] = i;
				sen++;
				break;
			case "District Representative":
				data[dist][1] = candidates.get(i).getName();
				data[dist][0] = i;
				dist++;
				break;
			case "Governor":
				data[gov][1] = candidates.get(i).getName();
				data[gov][0] = i;
				gov++;
				break;
			case "Mayor":
				data[may][1] = candidates.get(i).getName();
				data[may][0] = i;
				may++;
				break;
			}
		}

		// Create the check boxes.
		JCheckBox[] president = new JCheckBox[3];
		president[0] = new JCheckBox((String) data[0][1]);
		president[1] = new JCheckBox((String) data[1][1]);
		president[2] = new JCheckBox((String) data[2][1]);

		JCheckBox[] vicePresident = new JCheckBox[3];
		vicePresident[0] = new JCheckBox((String) data[3][1]);
		vicePresident[1] = new JCheckBox((String) data[4][1]);
		vicePresident[2] = new JCheckBox((String) data[5][1]);

		JCheckBox[] senator = new JCheckBox[10];
		senator[0] = new JCheckBox((String) data[6][1]);
		senator[1] = new JCheckBox((String) data[7][1]);
		senator[2] = new JCheckBox((String) data[8][1]);
		senator[3] = new JCheckBox((String) data[9][1]);
		senator[4] = new JCheckBox((String) data[10][1]);
		senator[5] = new JCheckBox((String) data[11][1]);
		senator[6] = new JCheckBox((String) data[12][1]);
		senator[7] = new JCheckBox((String) data[13][1]);
		senator[8] = new JCheckBox((String) data[14][1]);
		senator[9] = new JCheckBox((String) data[15][1]);

		JCheckBox[] districtRepresentative = new JCheckBox[10];
		districtRepresentative[0] = new JCheckBox((String) data[16][1]);
		districtRepresentative[1] = new JCheckBox((String) data[17][1]);
		districtRepresentative[2] = new JCheckBox((String) data[18][1]);
		districtRepresentative[3] = new JCheckBox((String) data[19][1]);
		districtRepresentative[4] = new JCheckBox((String) data[20][1]);
		districtRepresentative[5] = new JCheckBox((String) data[21][1]);
		districtRepresentative[6] = new JCheckBox((String) data[22][1]);
		districtRepresentative[7] = new JCheckBox((String) data[23][1]);
		districtRepresentative[8] = new JCheckBox((String) data[24][1]);
		districtRepresentative[9] = new JCheckBox((String) data[25][1]);

		JCheckBox[] governor = new JCheckBox[3];
		governor[0] = new JCheckBox((String) data[26][1]);
		governor[1] = new JCheckBox((String) data[27][1]);
		governor[2] = new JCheckBox((String) data[28][1]);

		JCheckBox[] mayor = new JCheckBox[3];
		mayor[0] = new JCheckBox((String) data[29][1]);
		mayor[1] = new JCheckBox((String) data[30][1]);
		mayor[2] = new JCheckBox((String) data[31][1]);

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
		frame.setLocationRelativeTo(null);

		// Add the action listeners to the buttons.
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Check if the voter has voted for the president.
				int count = 0;
				// make an int array to store the index of the selected 14 candidates
				int[] selected = new int[14];
				int selectedCount = 0;

				for (int i = 0; i < president.length; i++) {
					if (president[i].isSelected()) {
						count++;
						selected[selectedCount] = (int) data[i][0];
						selectedCount++;
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
						selected[selectedCount] = (int) data[i + 3][0];
						selectedCount++;
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
						selected[selectedCount] = (int) data[i + 6][0];
						selectedCount++;
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
						selected[selectedCount] = (int) data[i + 16][0];
						selectedCount++;
					}
				}
				if (count != 5) {
					JOptionPane.showMessageDialog(null,
							"Please select five (5) candidates for District Representative.");
					return;
				}

				// Check if the voter has voted for the governor.
				count = 0;
				for (int i = 0; i < governor.length; i++) {
					if (governor[i].isSelected()) {
						count++;
						selected[selectedCount] = (int) data[i + 26][0];
						selectedCount++;
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
						selected[selectedCount] = (int) data[i + 29][0];
						selectedCount++;
					}
				}
				if (count != 1) {
					JOptionPane.showMessageDialog(null, "Please select one (1) candidate for Mayor.");
					return;
				}

				// Print the selected candidates.
				for (int i = 0; i < selected.length; i++) {
					candidates.get(selected[i]).addVote();
					System.out.println(
							candidates.get(selected[i]).getName() + " " + candidates.get(selected[i]).getVotes());
				}

				// If the voter has voted for all the candidates, display a message.
				JOptionPane.showMessageDialog(null, "Thank you for voting!");
				numVoterVoted++;

				// Close the frame.
				frame.dispose();

				// Make the voter voted.
				((Voter) users.get(index)).setVoted(true);

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