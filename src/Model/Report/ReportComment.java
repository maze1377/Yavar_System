package Model.Report;

public class ReportComment extends ReportMessage {
    private final int forumID;
    private final int commentID;
    private final int reportedUserID;

    public ReportComment(String msg, int reporterUserID, int reportedUserID, int forumID, int commentID) {
        super(msg, reporterUserID, ReportType.UserReport);
        this.reportedUserID = reportedUserID;
        this.forumID = forumID;
        this.commentID = commentID;
    }

    public int getReporterUserID() {
        return this.getReporterID();
    }

    public int getReportedUserID() {
        return reportedUserID;
    }

    public int getForumID() {
        return forumID;
    }

    public int getCommentID() {
        return commentID;
    }
}
