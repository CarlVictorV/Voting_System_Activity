
/**
 * This class represents the GUI for the Voter Menu and the Voting page.
 * It extends the abstract class GUI.
 * @param args The command line arguments.
 * @return None.
 * @throws None.
 * 
 * @author Carl Victor Villaceran
 * @version 1.0
 * @contributor T-jay Abunales
 * @contributor Raynor Buhian
 */

 import java.awt.GridLayout;
 import java.awt.event.ActionEvent;
 import java.awt.event.ActionListener;
 import java.util.ArrayList;
 
 import javax.swing.BoxLayout;
 import javax.swing.JButton;
 import javax.swing.JCheckBox;
 import javax.swing.JFrame;
 import javax.swing.JLabel;
 import javax.swing.JOptionPane;
 import javax.swing.JPanel;
 import javax.swing.JScrollPane;
 
 public class VoterGUI extends GUI {
 
	 /**
	  * Constructs a VoterGUI object.
	  * 
	  * @param users      an ArrayList of Users representing all users
	  * @param candidates an ArrayList of Candidates representing all candidates
	  */
	 public VoterGUI(ArrayList<User> users, ArrayList<Candidates> candidates) {
		 super(users, candidates);
	 }
 
	 private static final long serialVersionUID = 1L;
 
	 /**
	  * Creates the GUI for the Voter Menu.
	  * 
	  * @param index an integer representing the index of the current user
	  */
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
					 frame.dispose();
					 voteSummaryGUI(index);
				 }
			 });
			 frame.add(displayResultsButton);
		 }
 
		 displayCandidateButton.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
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
 
	 /**
	  * Creates the GUI for the Voting page.
	  * 
	  * @param index an integer representing the index of the current user
	  */
 
	 public static void VoteGUI(int index) {
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
 
		 JButton submit = new JButton("Submit");
		 JButton cancel = new JButton("Cancel");
		 panel.add(submit);
		 panel.add(cancel);
		 frame.add(scroll);
		 frame.setVisible(true);
		 frame.setLocationRelativeTo(null);
 
		 submit.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 int count = 0;
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
 
				 for (int i = 0; i < selected.length; i++) {
					 candidates.get(selected[i]).addVote();
					 System.out.println(
							 candidates.get(selected[i]).getName() + " " + candidates.get(selected[i]).getVotes());
				 }
				 JOptionPane.showMessageDialog(null, "Thank you for voting!");
				 numVoterVoted++;
				 frame.dispose();
				 ((Voter) users.get(index)).setVoted(true);
				 VoterMenuGUI(index);
 
			 }
 
		 });
 
		 cancel.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 frame.dispose();
				 VoterMenuGUI(index);
			 }
		 });
 
	 }
 
 }