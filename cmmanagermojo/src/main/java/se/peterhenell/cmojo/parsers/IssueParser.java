package se.peterhenell.cmojo.parsers;

import se.peterhenell.cmojo.dto.IssueInfo;

public interface IssueParser {

	IssueInfo parse(String gitCommitMessage);

}
