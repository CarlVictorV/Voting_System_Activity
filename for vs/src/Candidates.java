public class Candidates {
	private String name = "";
	private int votes = 0;
	private String position = "";

	public Candidates() {
	}

	public Candidates(String name, String position) {
		this.name = name;
		this.position = position;
		this.votes = 0;
	}

	public Candidates(String name, String position, int votes) {
		this.name = name;
		this.position = position;
		this.votes = votes;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getVotes() {
		return votes;
	}

	public void setVotes(int votes) {
		this.votes = votes;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public void addVote() {
		this.votes++;
	}
}
//Finished prototype.