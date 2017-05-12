package com.peterhenell.se.cm;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

public class CommitDTO {

    String message;
	String committedBy;
    String commitId;
    int committedAt;
    String jiraIssue;
    String jiraSummary;
    String jiraDescription;
    Map<String, String> jiraFields;
	
    public CommitDTO(String message, String committedBy, String commitId, int committedAt, String jiraIssue,
			String jiraSummary, String jiraDescription) {
		super();
		this.message = message;
		this.committedBy = committedBy;
		this.commitId = commitId;
		this.committedAt = committedAt;
		this.jiraIssue = jiraIssue;
		this.jiraSummary = jiraSummary;
		this.jiraDescription = jiraDescription;
		
		this.jiraFields = new HashMap<String, String>();
	}
	
    @Override
	public String toString() {
		return "CommitDTO [message=" + message + ", committedBy=" + committedBy + ", commitId=" + commitId
				+ ", committedAt=" + committedAt + ", jiraIssue=" + jiraIssue + ", jiraSummary=" + jiraSummary
				+ ", jiraDescription=" + jiraDescription + "]";
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
	public String getJiraIssue() {
		return jiraIssue;
	}
	public String getJiraSummary() {
		return jiraSummary;
	}
	public String getJiraDescription() {
		return jiraDescription;
	}
	public Map<String, String> getJiraFields() {
		return jiraFields;
	}

	
    

}