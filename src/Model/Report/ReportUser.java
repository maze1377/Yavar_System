package Model.Report;

import Model.User;

public class ReportUser extends ReportMessage {
    private final int reportedUserID;

    public ReportUser(String msg, int idMessage, User sender, int reportedUserID) {
        super(ReportType.UserReport, msg, idMessage, sender);
        this.reportedUserID = reportedUserID;
    }

    public int getReportedUserID() {
        return reportedUserID;
    }
}
