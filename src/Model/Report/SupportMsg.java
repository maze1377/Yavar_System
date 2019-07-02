package Model.Report;

import Model.User;

public class SupportMsg extends ReportSingleMsg {
    private ReportSingleMsg nextMsg;

    public SupportMsg(String msg, int idMessage, User sender, ReportSingleMsg nextMsg) {
        super(ReportType.Support, msg, idMessage, sender);
        this.nextMsg = nextMsg;
    }

    public ReportSingleMsg getNextMsg() {
        return nextMsg;
    }

    public void setNextMsg(ReportSingleMsg nextMsg) {
        this.nextMsg = nextMsg;
    }
}
