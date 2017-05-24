package se.peterhenell.cm.dto;

public class CommitDTO {

	String message;
	String committedBy;
	String commitId;
	int committedAt;
	

	public CommitDTO(String message, String committedBy, String commitId, int committedAt) {
		super();
		this.message = message;
		this.committedBy = committedBy;
		this.commitId = commitId;
		this.committedAt = committedAt;		
	}

	@Override
	public String toString() {
		return "CommitDTO [message=" + message + ", committedBy=" + committedBy + ", commitId=" + commitId
				+ ", committedAt=" + committedAt + "]";
	}

	public String getMessage() {
		return message;
	}

	public String getCommittedBy() {
		return committedBy;
	}

	public String getCommitId() {
		return commitId;
	}

	public int getCommittedAt() {
		return committedAt;
	}
}