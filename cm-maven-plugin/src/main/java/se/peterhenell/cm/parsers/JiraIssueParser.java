package se.peterhenell.cm.parsers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.maven.plugin.logging.Log;

import se.peterhenell.cm.dto.JiraIssueDTO;

public class JiraIssueParser {

	private Log logger;

	public JiraIssueParser(Log log) {
		if (null == log) {
			log = new SysOutLogger();
		}

		this.logger = log;
	}

	public JiraIssueDTO parse(String gitCommitMessage) {
		JiraIssueDTO dto = JiraIssueDTO.UnknownIssue;
		
		Pattern r = Pattern.compile("(.*)-(\\d+)(.*)");

		Matcher m = r.matcher(gitCommitMessage);
		if (m.find()) {
			if (m.groupCount() >= 3) {
				String projectKey = m.group(1).trim();
				String jiraIssue = m.group(2).trim();
				String message = m.group(3).trim();

				dto = JiraIssueDTO.create(projectKey, jiraIssue, message);
			}
		}
		
		logger.debug("Parse Result : " + dto.toString());
		return dto;
	}

}
