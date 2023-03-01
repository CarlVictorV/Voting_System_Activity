import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI {
	private JFrame frame;
	private JLabel userLabel;
	private JLabel passwordLabel;
	private JTextField userText;
	private JPasswordField passwordText;
	private JButton loginButton;
	private JButton cancelButton;

	public void LoginGUI() {
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

		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = userText.getText();
				String password = new String(passwordText.getPassword());

				// code to verify username and password 
                // if username and password are correct

                //I think its better using for each loop

                for(users : User) {
                    if (username.equals(users.getUserName()) && password.equals(users.getPassword())) {
                        //if the user is an officer
                        if (users instanceof Officer) {
                            //display officer menu
                            OfficerMenuGUI();
                        }
                        //if the user is a voter
                        else if (users instanceof Voter) {
                            //display voter menu
                            VoterMenuGUI();
                        }
                        //if the user is a superuser
                        else if (users instanceof SuperUser) {
                            //display superuser menu
                            SuperUserMenuGUI();
                        }
                    }
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

    public void OfficerMenuGUI() {
        frame = new JFrame("Officer Menu");
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(3, 2));

        JButton addCandidateButton = new JButton("Add Candidate");
        JButton editCandidateButton = new JButton("Edit Candidate");
        JButton removeCandidateButton = new JButton("Remove Candidate");
        JButton displayCandidateButton = new JButton("Display Candidate");
        JButton logoutButton = new JButton("Logout");

        addCandidateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //display add candidate form
                AddCandidateGUI();
            }
        });

        editCandidateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //display edit candidate form
                EditCandidateGUI();
            }
        });

        removeCandidateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //display remove candidate form
                RemoveCandidateGUI();
            }
        });

        displayCandidateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //display display candidate form
                DisplayCandidateGUI();
            }
        });

        logoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //display login form
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

    public void VoterMenuGUI() {
        frame = new JFrame("Voter Menu");
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(3, 2));

        JButton voteButton = new JButton("Vote");
        JButton displayCandidateButton = new JButton("Display Candidate");
        JButton logoutButton = new JButton("Logout");

        voteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //display vote form
                VoteGUI();
            }
        });

        displayCandidateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //display display candidate form
                DisplayCandidateGUI();
            }
        });

        logoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //display login form
                LoginGUI();
            }
        });

        frame.add(voteButton);
        frame.add(displayCandidateButton);
        frame.add(logoutButton);
        frame.setVisible(true);
    }

    public void SuperUserMenuGUI()//ADD USER SPECICALLY OFFICER AND VOTER
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

        addUserButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //display add user form
                AddUserGUI();
            }
        });

        editUserButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //display edit user form
                EditUserGUI();
            }
        });

        removeUserButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //display remove user form
                RemoveUserGUI();
            }
        });

        displayUserButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //display display user form
                DisplayUserGUI();
            }
        });

        logoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //display login form
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

    public void AddCandidateGUI() {
        frame = new JFrame("Add Candidate");
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(3, 2));

        JLabel candidateNameLabel = new JLabel("Candidate Name:");
        JLabel candidatePartyLabel = new JLabel("Candidate Party:");
        JTextField candidateNameText = new JTextField(20);
        JTextField candidatePartyText = new JTextField(20);
        JButton addButton = new JButton("Add");
        JButton cancelButton = new JButton("Cancel");

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //add candidate to database
                //display officer menu
                OfficerMenuGUI();
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //display officer menu
                OfficerMenuGUI();
            }
        });

        frame.add(candidateNameLabel);
        frame.add(candidateNameText);
        frame.add(candidatePartyLabel);
        frame.add(candidatePartyText);
        frame.add(addButton);
        frame.add(cancelButton);
        frame.setVisible(true);
    }

    public void EditCandidateGUI() {
        frame = new JFrame("Edit Candidate");
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(3, 2));

        JLabel candidateNameLabel = new JLabel("Candidate Name:");
        JLabel candidatePartyLabel = new JLabel("Candidate Party:");
        JTextField candidateNameText = new JTextField(20);
        JTextField candidatePartyText = new JTextField(20);
        JButton editButton = new JButton("Edit");
        JButton cancelButton = new JButton("Cancel");

        editButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //edit candidate in database
                //display officer menu
                OfficerMenuGUI();
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //display officer menu
                OfficerMenuGUI();
            }
        });

        frame.add(candidateNameLabel);
        frame.add(candidateNameText);
        frame.add(candidatePartyLabel);
        frame.add(candidatePartyText);
        frame.add(editButton);
        frame.add(cancelButton);
        frame.setVisible(true);
    }

    public void RemoveCandidateGUI() {
        frame = new JFrame("Remove Candidate");
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(3, 2));

        JLabel candidateNameLabel = new JLabel("Candidate Name:");
        JTextField candidateNameText = new JTextField(20);
        JButton removeButton = new JButton("Remove");
        JButton cancelButton = new JButton("Cancel");

        removeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //remove candidate from database
                //display officer menu
                OfficerMenuGUI();
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //display officer menu
                OfficerMenuGUI();
            }
        });

        frame.add(candidateNameLabel);
        frame.add(candidateNameText);
        frame.add(removeButton);
        frame.add(cancelButton);
        frame.setVisible(true);
    }

    public void DisplayCandidateGUI() {
        frame = new JFrame("Display Candidate");
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(3, 2));

        JLabel candidateNameLabel = new JLabel("Candidate Name:");
        JTextField candidateNameText = new JTextField(20);
        JButton displayButton = new JButton("Display");
        JButton cancelButton = new JButton("Cancel");

        displayButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //display candidate from database
                //display officer menu
                OfficerMenuGUI();
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //display officer menu
                OfficerMenuGUI();
            }
        });

        frame.add(candidateNameLabel);
        frame.add(candidateNameText);
        frame.add(displayButton);
        frame.add(cancelButton);
        frame.setVisible(true);
    }

    public void AddUserGUI() {
        frame = new JFrame("Add User");
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(3, 2));

        JLabel userNameLabel = new JLabel("User Name:");
        JLabel passwordLabel = new JLabel("Password:");
        JLabel userTypeLabel = new JLabel("User Type:");
        JTextField userNameText = new JTextField(20);
        JTextField passwordText = new JTextField(20);
        JTextField userTypeText = new JTextField(20);
        JButton addButton = new JButton("Add");
        JButton cancelButton = new JButton("Cancel");

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //add user to database
                //display super user menu
                SuperUserMenuGUI();
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //display super user menu
                SuperUserMenuGUI();
            }
        });

        frame.add(userNameLabel);
        frame.add(userNameText);
        frame.add(passwordLabel);
        frame.add(passwordText);
        frame.add(userTypeLabel);
        frame.add(userTypeText);
        frame.add(addButton);
        frame.add(cancelButton);
        frame.setVisible(true);
    }

    public void EditUserGUI() {
        frame = new JFrame("Edit User");
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(3, 2));

        JLabel userNameLabel = new JLabel("User Name:");
        JLabel passwordLabel = new JLabel("Password:");
        JLabel userTypeLabel = new JLabel("User Type:");
        JTextField userNameText = new JTextField(20);
        JTextField passwordText = new JTextField(20);
        JTextField userTypeText = new JTextField(20);
        JButton editButton = new JButton("Edit");
        JButton cancelButton = new JButton("Cancel");

        editButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //edit user in database
                //display super user menu
                SuperUserMenuGUI();
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //display super user menu
                SuperUserMenuGUI();
            }
        });

        frame.add(userNameLabel);
        frame.add(userNameText);
        frame.add(passwordLabel);
        frame.add(passwordText);
        frame.add(userTypeLabel);
        frame.add(userTypeText);
        frame.add(editButton);
        frame.add(cancelButton);
        frame.setVisible(true);
    }

    public void RemoveUserGUI() {
        frame = new JFrame("Remove User");
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(3, 2));

        JLabel userNameLabel = new JLabel("User Name:");
        JTextField userNameText = new JTextField(20);
        JButton removeButton = new JButton("Remove");
        JButton cancelButton = new JButton("Cancel");

        removeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //remove user from database
                //display super user menu
                SuperUserMenuGUI();
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //display super user menu
                SuperUserMenuGUI();
            }
        });

        frame.add(userNameLabel);
        frame.add(userNameText);
        frame.add(removeButton);
        frame.add(cancelButton);
        frame.setVisible(true);
    }

    public void DisplayUserGUI() {
        frame = new JFrame("Display User");
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(3, 2));

        JLabel userNameLabel = new JLabel("User Name:");
        JTextField userNameText = new JTextField(20);
        JButton displayButton = new JButton("Display");
        JButton cancelButton = new JButton("Cancel");

        displayButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //display user from database
                //display super user menu
                SuperUserMenuGUI();
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //display super user menu
                SuperUserMenuGUI();
            }
        });

        frame.add(userNameLabel);
        frame.add(userNameText);
        frame.add(displayButton);
        frame.add(cancelButton);
        frame.setVisible(true);
    }


    public void DisplayElectionGUI() {
        frame = new JFrame("Display Election");
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(3, 2));

        JLabel electionNameLabel = new JLabel("Election Name:");
        JTextField electionNameText = new JTextField(20);
        JButton displayButton = new JButton("Display");
        JButton cancelButton = new JButton("Cancel");

        displayButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //display election from database
                //display officer menu
                OfficerMenuGUI();
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //display officer menu
                OfficerMenuGUI();
            }
        });

        frame.add(electionNameLabel);
        frame.add(electionNameText);
        frame.add(displayButton);
        frame.add(cancelButton);
        frame.setVisible(true);
    }

}
