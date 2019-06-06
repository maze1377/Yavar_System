package Model.Report;

public class ReportUser extends ReportMessage {
    private final int reportedUserID;

    public ReportUser(String msg, int reporterUserID, int reportedUserID) {
        super(msg, reporterUserID, ReportType.UserReport);
        this.reportedUserID = reportedUserID;
    }

    public int getReporterUserID() {
        return this.getReporterID();
    }

    public int getReportedUserID() {
        return reportedUserID;
    }
}
