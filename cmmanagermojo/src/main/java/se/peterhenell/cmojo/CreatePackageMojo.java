package se.peterhenell.cmojo;

import java.util.List;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import se.peterhenell.cmojo.parsers.GitLogParser;
import se.peterhenell.cmojo.parsers.IssueParser;
import se.peterhenell.cmojo.parsers.JiraIssueParser;
import se.peterhenell.cmojo.releasenotes.JsonReleaseNotesProducer;
import se.peterhenell.cmojo.releasenotes.ReleaseNoteDTO;
import se.peterhenell.cmojo.releasenotes.ReleaseNotesProducer;

/**
 * Creates and stores package information
 *
 */
@Mojo(name = "createPackage")
public class CreatePackageMojo extends BaseCMMojo {
    /**
     * The version of the to be created package.
     */
    @Parameter(property = "createPackage.version", defaultValue = "${project.version}")
    private String version;

    /**
     * The version of the currently installed package.
     */
    @Parameter(property = "createPackage.previousVersion")
    private String previousVersion;

    /**
     * The identity of the project
     */
    @Parameter(property = "createPackage.project", defaultValue = "${project.groupId}.${project.artifactId}")
    private String project;

    /**
     * The date of when the package was built.
     */
    @Parameter(property = "createPackage.buildDate")
    private String buildDate;

    /**
     * The path to where the script is being run
     */
    @Parameter(property = "createPackage.localBuildPath", defaultValue = "${project.basedir}")
    private String localBuildPath;

    /**
     * The status of the package
     */
    @Parameter(property = "createPackage.packageStatus", defaultValue = "Building")
    private String packageStatus;
    
    @Parameter(property = "gitConfig")
    private GitConfig gitConfig;

    public void execute() throws MojoExecutionException {
    	Logging.SetLogging(this);

    	Logging.getLog().info(project);

        IssueParser jiraIssueParser = new JiraIssueParser();        
        GitLogParser parser = new GitLogParser(jiraIssueParser);
        
        List<ReleaseNoteDTO> notes = parser.getGitLog(previousVersion, version, gitConfig);
 
        if (notes.isEmpty()) {
			Logging.getLog().info("No Git Logs found between " + version + " and " + previousVersion );
		}
        
        ReleaseNotesProducer producer = new JsonReleaseNotesProducer();
        
        producer.Produce(notes);       
    }
}