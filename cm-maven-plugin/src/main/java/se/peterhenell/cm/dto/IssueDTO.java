package se.peterhenell.cm.dto;

public class IssueDTO {

	public static final IssueDTO UnknownIssue = IssueDTO.create("Uknown", "Unknown", "No comment");

	private String issue;
	private String projectKey;
	private String comment;

	@Override
	public String toString() {
		return "IssueDTO [issue=" + issue + ", projectKey=" + projectKey + ", comment=" + comment + "]";
	}

	private IssueDTO() {
	}

	public static IssueDTO create(String projectKey, String jiraIssue, String comment) {
		IssueDTO k = new IssueDTO();
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
