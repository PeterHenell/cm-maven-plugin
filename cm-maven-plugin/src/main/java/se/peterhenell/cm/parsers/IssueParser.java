package se.peterhenell.cm.parsers;

import se.peterhenell.cm.dto.IssueDTO;

public interface IssueParser {

	IssueDTO parse(String gitCommitMessage);

}
