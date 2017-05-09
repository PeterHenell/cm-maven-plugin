package sample.plugin;
 
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
 
/**
 * Says "Hi" to the user.
 *
 */
@Mojo( name = "createPackage")
public class CreatePackageMojo extends BaseCMMojo
{
    /**
     * The greeting to display.
     */
    @Parameter( property = "createPackage.version", defaultValue = "${project.version}" )
    private String version;
    
    /**
     * The greeting to display.
     */
    @Parameter( property = "createPackage.project", defaultValue = "${project.groupId}.${project.artifactId}" )
    private String project;
    
    /**
     * The greeting to display.
     */
    @Parameter( property = "createPackage.buildDate", defaultValue = "Hello World!" )
    private String buildDate;
    
    /**
     * The greeting to display.
     */
    @Parameter( property = "createPackage.localBuildPath", defaultValue = "${project.basedir}" )
    private String localBuildPath;
    
    /**
     * The greeting to display.
     */
    @Parameter( property = "createPackage.pathToGitRepo", defaultValue = "${project.basedir}" )
    private String pathToGitRepo;
    
    /**
     * The greeting to display.
     */
    @Parameter( property = "createPackage.branch", defaultValue = "master" )
    private String branch;
    
    /**
     * The greeting to display.
     */
    @Parameter( property = "createPackage.packageStatus", defaultValue = "Building" )
    private String packageStatus;
    
    

    public void execute() throws MojoExecutionException
    {
        getLog().info( project );
    }
}