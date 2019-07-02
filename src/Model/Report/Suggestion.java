package Model.Report;

import Model.User;

public class Suggestion extends ReportSingleMsg {

    public Suggestion(String msg, int idMessage, User sender) {
        super(ReportType.Suggestions, msg, idMessage, sender);
    }
}
