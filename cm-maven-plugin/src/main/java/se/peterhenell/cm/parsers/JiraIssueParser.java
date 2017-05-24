package se.peterhenell.cm.parsers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import se.peterhenell.cm.Logging;
import se.peterhenell.cm.dto.IssueInfo;

public class JiraIssueParser implements IssueParser {

	public JiraIssueParser() {
	}

	@Override
	public IssueInfo parse(String gitCommitMessage) {
		IssueInfo dto = IssueInfo.UnknownIssue;
		
		Pattern r = Pattern.compile("(.*)-(\\d+)(.*)");

		Matcher m = r.matcher(gitCommitMessage);
		if (m.find()) {
			if (m.groupCount() >= 3) {
				String projectKey = m.group(1).trim();
				String jiraIssue = m.group(2).trim();
				String message = m.group(3).trim();

				dto = IssueInfo.create(projectKey, jiraIssue, message);
			}
		}
		
		Logging.getLog().debug("Parse Result : " + dto.toString());
		return dto;
	}

}
