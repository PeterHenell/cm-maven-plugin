package se.peterhenell.cm.releasenotes;

import se.peterhenell.cm.dto.CommitInfo;
import se.peterhenell.cm.dto.IssueInfo;

public class ReleaseNoteDTO {

	private IssueInfo jiraIssue;
	private CommitInfo commit;

	@Override
	public String toString() {
		return "ReleaseNoteDTO [jiraIssue=" + jiraIssue + ", commit=" + commit + "]";
	}

	public ReleaseNoteDTO(CommitInfo commit, IssueInfo jiraIssue) {
		this.setCommit(commit);
		this.setJiraIssue(jiraIssue);
	}

	public CommitInfo getCommit() {
		return commit;
	}

	public void setCommit(CommitInfo commit) {
		this.commit = commit;
	}

	public IssueInfo getJiraIssue() {
		return jiraIssue;
	}

	public void setJiraIssue(IssueInfo jiraIssue) {
		this.jiraIssue = jiraIssue;
	}

}
