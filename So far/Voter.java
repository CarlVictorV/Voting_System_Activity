public class Voter extends User {
	private boolean voted = false;
	
	public boolean isVoted() {
		return voted;
	}
	public void setVoted(boolean voted) {
		this.voted = voted;
	}

}
