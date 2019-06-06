package Model.Report;

public class ReportDoc extends ReportMessage {
    private final int reportedDocID;


    public ReportDoc(String msg, int reporterUserID, int reportedDocID) {
        super(msg, reporterUserID, ReportType.UserReport);
        this.reportedDocID = reportedDocID;
    }

    public int getReporterUserID() {
        return this.getReporterID();
    }

    public int getReportedDocID() {
        return reportedDocID;
    }
}
