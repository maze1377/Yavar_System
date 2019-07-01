package Model.Report;

import Model.User;

public class ReportDoc extends ReportMessage {
    private final int reportedDocID;


    public ReportDoc(String msg, int idMessage, User sender, User reciever, int reportedDocID) {
        super(msg, idMessage, sender, reciever, ReportType.DocReport);
        this.reportedDocID = reportedDocID;
    }

    public int getReportedDocID() {
        return reportedDocID;
    }
}
