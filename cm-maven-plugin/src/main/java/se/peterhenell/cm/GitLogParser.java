package se.peterhenell.cm;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;

import se.peterhenell.cm.dto.CommitDTO;
import se.peterhenell.cm.dto.IssueDTO;



public class GitLogParser {

	private IssueParser issueParser;

	public GitLogParser(IssueParser issueParser) {
		this.issueParser = issueParser;
	}

	private Repository getRepository(GitConfig gitConfig){
		try {
            Repository existingRepo = new FileRepositoryBuilder().setGitDir(new File(gitConfig.getPathToGitRepo() + "\\.git")).build();
            return existingRepo;
        } catch (IOException ex) {
            Logging.getLog().error("could not get git repo" + ex.getMessage());            
        }
		return null;
	}
	
	public List<ReleaseNoteDTO> getGitLog(GitConfig gitConfig) {
		List<ReleaseNoteDTO> commits = new ArrayList<>();
		Repository repository = getRepository(gitConfig);
		try {
			Git git = new Git(repository);
			Iterable<RevCommit> logs = git.log().call();

			for (RevCommit rev : logs) {
				IssueDTO jiraIssue = issueParser.parse(rev.getFullMessage());

				CommitDTO commit = new CommitDTO(rev.getFullMessage(), rev.getCommitterIdent().getEmailAddress(),
						rev.getId().toString(), rev.getCommitTime());

				ReleaseNoteDTO releaseNote = new ReleaseNoteDTO(commit, jiraIssue);
				commits.add(releaseNote);
			}

		} catch (Exception e) {
			Logging.getLog().error(e.getMessage());
		}
		return commits;
	}

}
