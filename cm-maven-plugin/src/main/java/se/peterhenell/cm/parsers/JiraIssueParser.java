package se.peterhenell.cm.parsers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import se.peterhenell.cm.Logging;
import se.peterhenell.cm.dto.IssueDTO;

public class JiraIssueParser implements IssueParser {

	public JiraIssueParser() {
	}

	@Override
	public IssueDTO parse(String gitCommitMessage) {
		IssueDTO dto = IssueDTO.UnknownIssue;
		
		Pattern r = Pattern.compile("(.*)-(\\d+)(.*)");

		Matcher m = r.matcher(gitCommitMessage);
		if (m.find()) {
			if (m.groupCount() >= 3) {
				String projectKey = m.group(1).trim();
				String jiraIssue = m.group(2).trim();
				String message = m.group(3).trim();

				dto = IssueDTO.create(projectKey, jiraIssue, message);
			}
		}
		
		Logging.getLog().debug("Parse Result : " + dto.toString());
		return dto;
	}

}
