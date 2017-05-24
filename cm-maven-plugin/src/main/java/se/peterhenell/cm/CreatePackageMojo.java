package se.peterhenell.cm;

import java.util.List;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import se.peterhenell.cm.parsers.JiraIssueParser;

/**
 * Creates and stores package information
 *
 */
@Mojo(name = "createPackage")
public class CreatePackageMojo extends BaseCMMojo {
    /**
     * The version of the package.
     */
    @Parameter(property = "createPackage.version", defaultValue = "${project.version}")
    private String version;

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
    
    @Parameter(property = "git.config")
    private GitConfig gitConfig;

    public void execute() throws MojoExecutionException {
    	Logging.SetLogging(this);

    	Logging.getLog().info(project);

        IssueParser jiraIssueParser = new JiraIssueParser();        
        GitLogParser parser = new GitLogParser(jiraIssueParser);
        
        List<ReleaseNoteDTO> notes = parser.getGitLog(gitConfig);
 
        ReleaseNotesProducer producer = new TextReleaseNotesProducer();
        
        producer.Produce(notes);       
    }
}