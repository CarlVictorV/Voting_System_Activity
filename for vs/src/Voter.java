public class Voter extends User {
	private boolean voted = false;

	public Voter(String string, String string2, String string3) {
		super(string, string2, string3);
	}

	public Voter(String string, String string2, String string3, boolean voted) {
		super(string, string2, string3);
		this.voted = voted;
	}

	public boolean isVoted() {
		return voted;
	}

	public void setVoted(boolean voted) {
		this.voted = voted;
	}

}
//Finished prototype.