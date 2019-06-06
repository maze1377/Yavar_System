package Model.Report;

public class Suggestion extends ReportMessage {

    public Suggestion(String msg, int ReporterID) {
        super(msg, ReporterID, ReportType.Suggestions);
    }
}
