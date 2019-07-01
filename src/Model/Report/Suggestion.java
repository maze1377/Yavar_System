package Model.Report;

public class Suggestion extends ReportMessage {

    public Suggestion(String msg, int idMessage, int sender) {
        super(ReportType.Suggestions, msg, idMessage, sender);
    }
}
