package com.peterhenell.se.cm;

import java.io.File;
import java.io.IOException;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;

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
            Repository existingRepo = new FileRepositoryBuilder().setGitDir(new File(pathToGitRepo+"\\.git")).build();
            Ref master = existingRepo.getRef("master");
            ObjectId id = master.getObjectId();
            getLog().info(id.toString());

        } catch (IOException ex) {
            getLog().error("could not get git repo" + ex.getMessage());
        }
    }
}