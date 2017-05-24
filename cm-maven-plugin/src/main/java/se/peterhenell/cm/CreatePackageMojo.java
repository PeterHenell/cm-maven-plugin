package se.peterhenell.cm;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;

import se.peterhenell.cm.dto.CommitDTO;
import se.peterhenell.cm.dto.JiraIssueDTO;
import se.peterhenell.cm.parsers.JiraIssueParser;

/**
 * Creates and stores package information
 *
 */
@Mojo(name = "createPackage")
public class CreatePackageMojo extends BaseCMMojo {
    /**
     * The greeting to display.
     */
    @Parameter(property = "createPackage.version", defaultValue = "${project.version}")
    private String version;

    /**
     * The greeting to display.
     */
    @Parameter(property = "createPackage.project", defaultValue = "${project.groupId}.${project.artifactId}")
    private String project;

    /**
     * The greeting to display.
     */
    @Parameter(property = "createPackage.buildDate", defaultValue = "Hello World!")
    private String buildDate;

    /**
     * The greeting to display.
     */
    @Parameter(property = "createPackage.localBuildPath", defaultValue = "${project.basedir}")
    private String localBuildPath;

    /**
     * The greeting to display.
     */
    @Parameter(property = "createPackage.pathToGitRepo", defaultValue = "${project.basedir}")
    private String pathToGitRepo;

    /**
     * The greeting to display.
     */
    @Parameter(property = "createPackage.branch", defaultValue = "master")
    private String branch;

    /**
     * The greeting to display.
     */
    @Parameter(property = "createPackage.packageStatus", defaultValue = "Building")
    private String packageStatus;

    public void execute() throws MojoExecutionException {
        getLog().info(project);

        
        
        try {
            Repository existingRepo = new FileRepositoryBuilder().setGitDir(new File(pathToGitRepo + "\\.git")).build();
            List<ReleaseNoteDTO> commits = ListLog(existingRepo);
            for (ReleaseNoteDTO commitDTO : commits) {
				getLog().info(commitDTO.toString());
			}           
            
        } catch (IOException ex) {
            getLog().error("could not get git repo" + ex.getMessage());
        }
    }

    private List<ReleaseNoteDTO> ListLog(Repository repository) {
    	
    	List<ReleaseNoteDTO> commits = new ArrayList<>();

    	JiraIssueParser jiraParser = new JiraIssueParser(getLog());
    	
        try {
            Git git = new Git(repository);
            Iterable<RevCommit> logs = git.log().call();
            
            for (RevCommit rev : logs) {              
            	
            	JiraIssueDTO jiraIssue = jiraParser.parse(rev.getFullMessage());            	
            	
                CommitDTO c = new CommitDTO(rev.getFullMessage(), rev.getCommitterIdent().getEmailAddress(), rev.getId().toString(), rev.getCommitTime());
                
                ReleaseNoteDTO releaseNote = new ReleaseNoteDTO(c, jiraIssue);
                commits.add(releaseNote);            
            }

        } catch (Exception e) {
            getLog().error(e.getMessage());
        }
        return commits;
    }
}