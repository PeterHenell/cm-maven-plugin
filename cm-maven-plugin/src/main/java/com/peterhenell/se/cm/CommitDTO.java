package com.peterhenell.se.cm;

import java.sql.Date;
import java.util.Map;

public class CommitDTO {

    String message;
    String committedBy;
    String commitId;
    Date committedAt;
    String jiraIssue;
    String jiraSummary;
    String jiraDescription;
    Map<String, String> jiraFields;

    public CommitDTO() {
        
    }

}