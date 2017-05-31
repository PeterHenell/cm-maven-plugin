package se.peterhenell.cmojo;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import se.peterhenell.cmojo.dto.IssueInfo;
import se.peterhenell.cmojo.parsers.IssueParser;
import se.peterhenell.cmojo.parsers.JiraIssueParser;

/**
 * Unit test for simple App.
 */
public class JiraIssueParserTest 
    extends TestCase
{
    public JiraIssueParserTest( String testName )
    {
        super( testName );
    }

    public static Test suite()
    {
        return new TestSuite( JiraIssueParserTest.class );
    }

    public void testApp()
    {
    	IssueParser parser = new JiraIssueParser();
    	IssueInfo dto = parser.parse("NSWAG-5955 Providing better comment");
    	
    	assertEquals("5955", dto.getIssue());
    	assertEquals("NSWAG", dto.getProjectKey());
    	assertEquals("Providing better comment", dto.getComment());
    }
}
