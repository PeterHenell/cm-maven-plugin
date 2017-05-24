package se.peterhenell.cm;

import se.peterhenell.cm.dto.IssueDTO;

public interface IssueParser {

	IssueDTO parse(String gitCommitMessage);

}
