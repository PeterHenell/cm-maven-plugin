package se.peterhenell.cm;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import se.peterhenell.cm.dto.IssueDTO;

public interface IssueParser {

	IssueDTO parse(String gitCommitMessage);

}
