package se.peterhenell.cm.parsers;

import se.peterhenell.cm.dto.IssueInfo;

public interface IssueParser {

	IssueInfo parse(String gitCommitMessage);

}
