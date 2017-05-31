package se.peterhenell.cmojo.dto;

public class IssueInfo {

	public static final IssueInfo UnknownIssue = IssueInfo.create("Uknown", "Unknown", "No comment");

	private String issue;
	private String projectKey;
	private String comment;

	@Override
	public String toString() {
		return "Issue [issue=" + issue + ", projectKey=" + projectKey + ", comment=" + comment + "]";
	}

	private IssueInfo() {
	}

	public static IssueInfo create(String projectKey, String jiraIssue, String comment) {
		IssueInfo k = new IssueInfo();
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
