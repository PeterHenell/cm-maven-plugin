package se.peterhenell.cm;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import se.peterhenell.cm.dto.IssueDTO;
import se.peterhenell.cm.parsers.JiraIssueParser;

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
    	IssueDTO dto = parser.parse("NSWAG-5955 Providing better comment");
    	
    	assertEquals("5955", dto.getIssue());
    	assertEquals("NSWAG", dto.getProjectKey());
    	assertEquals("Providing better comment", dto.getComment());
    }
}
