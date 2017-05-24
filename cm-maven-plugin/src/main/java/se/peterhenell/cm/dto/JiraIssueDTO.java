package se.peterhenell.cm.dto;

public class JiraIssueDTO {

	public static final JiraIssueDTO UnknownIssue = JiraIssueDTO.create("Uknown", "Unknown", "No comment");

	private String issue;
	private String projectKey;
	private String comment;

	@Override
	public String toString() {
		return "JiraIssueDTO [issue=" + issue + ", projectKey=" + projectKey + ", comment=" + comment + "]";
	}

	private JiraIssueDTO() {
	}

	public static JiraIssueDTO create(String projectKey, String jiraIssue, String comment) {
		JiraIssueDTO k = new JiraIssueDTO();
		k.projectKey = projectKey;
		k.issue = jiraIssue;		
		k.comment = comment;
		return k;

	}

	public String getIssue() {
		return issue;
	}

	public String getProjectKey() {
		return projectKey;
	}

	public String getComment() {
		return comment;
	}
}
