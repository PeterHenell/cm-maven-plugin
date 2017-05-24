package se.peterhenell.cm;

import se.peterhenell.cm.dto.CommitDTO;
import se.peterhenell.cm.dto.JiraIssueDTO;

public class ReleaseNoteDTO {

	private JiraIssueDTO jiraIssueDTO;
	private CommitDTO commitDTO;

	@Override
	public String toString() {
		return "ReleaseNoteDTO [jiraIssueDTO=" + jiraIssueDTO + ", commitDTO=" + commitDTO + "]";
	}

	public ReleaseNoteDTO(CommitDTO commitDTO, JiraIssueDTO jiraIssueDTO) {
		this.setCommitDTO(commitDTO);
		this.setJiraIssueDTO(jiraIssueDTO);
	}

	public CommitDTO getCommitDTO() {
		return commitDTO;
	}

	public void setCommitDTO(CommitDTO commitDTO) {
		this.commitDTO = commitDTO;
	}

	public JiraIssueDTO getJiraIssueDTO() {
		return jiraIssueDTO;
	}

	public void setJiraIssueDTO(JiraIssueDTO jiraIssueDTO) {
		this.jiraIssueDTO = jiraIssueDTO;
	}

}
