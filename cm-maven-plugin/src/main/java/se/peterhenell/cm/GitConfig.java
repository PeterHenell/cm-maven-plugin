package se.peterhenell.cm;

public class GitConfig {

	public String getPathToGitRepo() {
		return pathToGitRepo;
	}

	public String getBranch() {
		return branch;
	}

	public void setPathToGitRepo(String pathToGitRepo) {
		this.pathToGitRepo = pathToGitRepo;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	private String pathToGitRepo;

	private String branch;
}
