package se.peterhenell.cm.releasenotes;

import se.peterhenell.cm.dto.CommitInfo;
import se.peterhenell.cm.dto.IssueInfo;

public class ReleaseNoteDTO {

	private IssueInfo issue;
	private CommitInfo commit;

	@Override
	public String toString() {
		return "ReleaseNoteDTO [Issue=" + issue + ", commit=" + commit + "]";
	}

	public ReleaseNoteDTO(CommitInfo commit, IssueInfo issue) {
		this.setCommit(commit);
		this.setIssue(issue);
	}

	public CommitInfo getCommit() {
		return commit;
	}

	public void setCommit(CommitInfo commit) {
		this.commit = commit;
	}

	public IssueInfo getIssue() {
		return issue;
	}

	public void setIssue(IssueInfo issue) {
		this.issue = issue;
	}

}
