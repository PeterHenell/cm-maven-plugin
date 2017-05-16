package com.peterhenell.se.cm;

public class CommitInfoDTO {

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    String message;
    String committedBy;
    String hash;
    Date committedAt;
    String branch;
    Map<String, String> jiraFields;
    String jiraIssue;

    public String getCommittedBy() {
        return committedBy;
    }

    public void setCommittedBy(String committedBy) {
        this.committedBy = committedBy;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public Map<String, String> getJiraFields() {
        return jiraFields;
    }

    public void setJiraFields(Map<String, String> jiraFields) {
        this.jiraFields = jiraFields;
    }

    public String getJiraIssue() {
        return jiraIssue;
    }

    public void setJiraIssue(String jiraIssue) {
        this.jiraIssue = jiraIssue;
    }

    public Date getCommittedAt() {

        return committedAt;
    }

    public void setCommittedAt(Date committedAt) {
        this.committedAt = committedAt;
    }

    public CommitInfoDTO(String message, String committedBy, String hash, Date committedAt, String branch, String jiraIssue) {
        this.message = message;
        this.committedBy = committedBy;
        this.hash = hash;
        this.committedAt = committedAt;
        this.branch = branch;
        this.jiraIssue = jiraIssue;
    }


}