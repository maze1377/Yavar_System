package Model.Report;

import Model.User;

public class SupportMsg extends ReportMessage {
    private ReportMessage nextMsg;

    public SupportMsg(String msg, int idMessage, User sender, ReportMessage nextMsg) {
        super(ReportType.Support, msg, idMessage, sender);
        this.nextMsg = nextMsg;
    }

    public ReportMessage getNextMsg() {
        return nextMsg;
    }

    public void setNextMsg(ReportMessage nextMsg) {
        this.nextMsg = nextMsg;
    }
}
