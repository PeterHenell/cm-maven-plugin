package se.peterhenell.cmojo;
 
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugins.annotations.Parameter;
 

public abstract class BaseCMMojo extends AbstractMojo
{
    /**
     * The connectionString
     */
    @Parameter( property = "createPackage.packageStatus", defaultValue = "jdbc://" )
    private String connectionString;

    /**
     * The username to use to connect to connectionString
     */
    @Parameter( property = "createPackage.packageStatus", defaultValue = "username" )
    private String username;


    /**
     * The password to use to connect to connectionString
     */
    @Parameter( property = "createPackage.packageStatus", defaultValue = "password" )
    private String password;
}