package com.peterhenell.se.cm;

import java.io.File;
import java.io.IOException;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;

/**
 * Says "Hi" to the user.
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
            ListLog(existingRepo);

        } catch (IOException ex) {
            getLog().error("could not get git repo" + ex.getMessage());
        }
    }

    private void ListLog(Repository repository) {
        try {
            Git git = new Git(repository);
            Iterable<RevCommit> logs = git.log().call();
            int count = 0;
            for (RevCommit rev : logs) {
                getLog().info("Commit: " + rev + ", name: " + rev.getName() + ", id: " + rev.getId().getName());
                //System.out.println("Commit: " + rev /* + ", name: " + rev.getName() + ", id: " + rev.getId().getName() */);
                count++;
            }
            System.out.println("Had " + count + " commits overall on current branch");

            logs = git.log().add(repository.resolve("remotes/origin/"+ branch)).call();
            count = 0;
            for (RevCommit rev : logs) {
                System.out.println(
                        "Commit: " + rev /* + ", name: " + rev.getName() + ", id: " + rev.getId().getName() */);
                count++;
            }
            System.out.println("Had " + count + " commits overall on test-branch");

            logs = git.log().not(repository.resolve("master")).add(repository.resolve("remotes/origin/"+ branch))
                    .call();
            count = 0;
            for (RevCommit rev : logs) {
                System.out.println(
                        "Commit: " + rev /* + ", name: " + rev.getName() + ", id: " + rev.getId().getName() */);
                count++;
            }
            System.out.println("Had " + count + " commits only on test-branch");

            logs = git.log().all().call();
            count = 0;
            for (RevCommit rev : logs) {
                //System.out.println("Commit: " + rev /* + ", name: " + rev.getName() + ", id: " + rev.getId().getName() */);
                count++;
            }
            System.out.println("Had " + count + " commits overall in repository");

            logs = git.log()
                    // for all log.all()
                    .addPath("README.md").call();
            count = 0;
            for (RevCommit rev : logs) {
                //System.out.println("Commit: " + rev /* + ", name: " + rev.getName() + ", id: " + rev.getId().getName() */);
                count++;
            }
            System.out.println("Had " + count + " commits on README.md");

            logs = git.log()
                    // for all log.all()
                    .addPath("pom.xml").call();
            count = 0;
            for (RevCommit rev : logs) {
                //System.out.println("Commit: " + rev /* + ", name: " + rev.getName() + ", id: " + rev.getId().getName() */);
                count++;
            }
            System.out.println("Had " + count + " commits on pom.xml");

        } catch (Exception e) {
            getLog().error(e.getMessage());
        }
    }
}