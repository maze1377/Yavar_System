package Model.Report;

import Model.User;

public class ReportDoc extends ReportSingleMsg implements AnswerableSingleMsg {
    private final int reportedDocID;

    public ReportDoc(String msg, int idMessage, User sender, int reportedDocID) {
        super(ReportType.DocReport, msg, idMessage, sender);
        this.reportedDocID = reportedDocID;
    }

    public int getReportedDocID() {
        return reportedDocID;
    }

    @Override
    public void answer(String msg) {

    }
}
