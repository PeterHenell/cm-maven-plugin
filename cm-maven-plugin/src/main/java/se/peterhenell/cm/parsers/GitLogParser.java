package se.peterhenell.cm.parsers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;

import se.peterhenell.cm.GitConfig;
import se.peterhenell.cm.Logging;
import se.peterhenell.cm.dto.CommitInfo;
import se.peterhenell.cm.dto.IssueInfo;
import se.peterhenell.cm.releasenotes.ReleaseNoteDTO;

public class GitLogParser {

	private IssueParser issueParser;

	public GitLogParser(IssueParser issueParser) {
		this.issueParser = issueParser;
	}

	private Repository getRepository(GitConfig gitConfig) throws IOException {
		Repository repo = new FileRepositoryBuilder().setGitDir(new File(gitConfig.getPathToGitRepo() + "\\.git"))
				.build();
		return repo;
	}

	public List<ReleaseNoteDTO> getGitLog(String previousVersion, String version, GitConfig gitConfig) {
		List<ReleaseNoteDTO> commits = new ArrayList<>();

		try {
			Repository repository = getRepository(gitConfig);

			Iterable<RevCommit> logs = getJGitLogBetween(repository, previousVersion, version);
			
			for (RevCommit rev : logs) {
				IssueInfo issue = issueParser.parse(rev.getFullMessage());

				CommitInfo commit = new CommitInfo(rev.getFullMessage(), rev.getCommitterIdent().getEmailAddress(),
						rev.getId().toString(), rev.getCommitTime());

				ReleaseNoteDTO releaseNote = new ReleaseNoteDTO(commit, issue);
				commits.add(releaseNote);
			}
		} catch (Exception e) {
			Logging.getLog().error(e.toString());
		}
		return commits;
	}
		
	private Iterable<RevCommit> getJGitLogBetween(final Repository repository, final String rev1, final String rev2) throws IOException, GitAPIException {
		ObjectId since = repository.resolve(rev1);
		ObjectId until = repository.resolve(rev2);
			
		return new Git(repository).log()
				.addRange(since, until)
				.call();
	}
}
