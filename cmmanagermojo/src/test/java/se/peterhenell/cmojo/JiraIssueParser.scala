package se.peterhenell.cmojo.parsers

import se.peterhenell.cmojo.dto.IssueInfo

/**
  * Created by mrm on 2017-06-06.
  */

class JiraIssueParser extends IssueParser {
  override def parse(gitCommitMessage: String): IssueInfo = {
    val r = """(.*)-(\d+)(.*)""".r

    gitCommitMessage match {
      case r(projectKey, jiraIssue, message) => IssueInfo.create(projectKey.trim, jiraIssue.trim, message.trim)
      case _ => IssueInfo.UnknownIssue
    }
  }
}
