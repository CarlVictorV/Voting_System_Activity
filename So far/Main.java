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
import java.util.List;
import java.util.Scanner;
public class Main {

    public static List<User> users = new ArrayList<User>();
    public static List<Candidate> candidates = new ArrayList<Candidate>();
    public static Scanner input = new Scanner(System.in);

    //create a global counter for the number of position 
    public static int numPresident = 0;
    public static int numVicePresident = 0;
    public static int numSenator = 0;
    public static int numRepresentative = 0;
    public static int numGovernor = 0;
    public static int numMayor = 0;
    public static int numVoter = 0;
    public static int numVoterVoted = 0;
    
    //Can the counters be seen by function boolean is candidateFull()? (yes/no) yes

	
	public static void main(String[] args) {
        //Can you set one SuperUser with the username admin and password admin? (yes/no) yes
        //Can you set the SuperUser as the first user? (yes/no) yes do it next line



	}
	
	//SuperUser
	public static void addOfficer() {}
	public static void addVoter() {}
	public static void editUser() {}
	public static void removeUser() {}
	public static void displayUser() {}
	
	//Officer
	public static void addCandidate() {}
	public static void editCandidate() {}
	public static void removeCandidate() {}
	public static void displayCandidate() {}
	
	
	//voters
	public static void voteCandidates() {}
	public static boolean candidateFull() //Purpose: To check if the number of candidates is equal to the number of allowed candidates so that the voter can start voting.
    {
        //return true if the number of candidates is equal to the number of allowed candidates.
        //return false if the number of candidates is less than the number of allowed candidates.
        //Again stated above is the maximum number of candidates per position.

        if (numPresident == 3 && numVicePresident == 3 && numSenator == 10 && numRepresentative == 10 && numGovernor == 3 && numMayor == 3) {
            return true;
        } else {
            return false;
        }
    }

    

	//Global
	public static void logIn() {}
	public static void logOut() {}
	public static void voteSummary() {}
	public static void GUI() {}


    //Debugging purposes
    //create a public static void adddummy() {} that will add dummy data for the users
    public static void addDummy() {
        //add dummy data for the users
        //1 SuperUser, 1 Officer, 5 Voters

        //SuperUser
        users.add(new SuperUser("admin", "admin", "SuperUser"));

        //Officers
        users.add(new Officer("officer", "officer", "Officer"));

        //Voters
        users.add(new Voter("voter1", "voter1", "Voter"));
        users.add(new Voter("voter2", "voter2", "Voter"));
        users.add(new Voter("voter3", "voter3", "Voter"));
        users.add(new Voter("voter4", "voter4", "Voter"));
        users.add(new Voter("voter5", "voter5", "Voter"));
    }
		
}

// I might prioritize the functionality first before the GUI. I have no experience in GUI, so I might need to learn it first.
// Should I use Switch case, does it also continue to the GUI? (yes/no) yes 