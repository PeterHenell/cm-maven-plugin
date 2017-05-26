package se.peterhenell.cm;

import java.io.File;
import java.io.IOException;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import se.peterhenell.cm.parsers.GitLogParser;
import se.peterhenell.cm.parsers.JiraIssueParser;

/**
 * Unit test for simple App.
 */
public class GitLogParserTest extends TestCase {
	public GitLogParserTest(String testName) {
		super(testName);
	}

	public static Test suite() {
		return new TestSuite(GitLogParserTest.class);
	}

	public void testApp() {
		 GitLogParser parser = new GitLogParser(new JiraIssueParser());
		 GitConfig gitConfig = new GitConfig();
		 gitConfig.setBranch("master");
		 gitConfig.setPathToGitRepo("C:\\src\\github\\cm-maven-plugin");
		
		 parser.getGitLog("730e6ef34aabfa67ec206d444e21ed1eec824135",
		 "d0e5b9d13362c3c891efb18dea018058153aa0c5", gitConfig );
	}
}
