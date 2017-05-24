package se.peterhenell.cm.releasenotes;

import se.peterhenell.cm.dto.CommitDTO;
import se.peterhenell.cm.dto.IssueDTO;

public class ReleaseNoteDTO {

	private IssueDTO jiraIssueDTO;
	private CommitDTO commitDTO;

	@Override
	public String toString() {
		return "ReleaseNoteDTO [jiraIssueDTO=" + jiraIssueDTO + ", commitDTO=" + commitDTO + "]";
	}

	public ReleaseNoteDTO(CommitDTO commitDTO, IssueDTO jiraIssueDTO) {
		this.setCommitDTO(commitDTO);
		this.setJiraIssueDTO(jiraIssueDTO);
	}

	public CommitDTO getCommitDTO() {
		return commitDTO;
	}

	public void setCommitDTO(CommitDTO commitDTO) {
		this.commitDTO = commitDTO;
	}

	public IssueDTO getJiraIssueDTO() {
		return jiraIssueDTO;
	}

	public void setJiraIssueDTO(IssueDTO jiraIssueDTO) {
		this.jiraIssueDTO = jiraIssueDTO;
	}

}
