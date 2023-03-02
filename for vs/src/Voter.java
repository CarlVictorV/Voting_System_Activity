public class Voter extends User {
	private boolean voted = false;
	
	public Voter(String string, String string2, String string3) {
		super(string, string2, string3);
	}
	public boolean isVoted() {
		return voted;
	}
	public void setVoted(boolean voted) {
		this.voted = voted;
	}

}
