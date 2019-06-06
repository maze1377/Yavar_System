package Model.Report;

import java.util.ArrayList;
// For each user that has never used Support Section it will be created once and only
public class Support {
    private final ArrayList<ReportMessage> msgs;

    public Support() {
        this.msgs = new ArrayList();
    }

    public ArrayList<ReportMessage> getMsgs() {
        return msgs;
    }

    public void addMsg(String msg, int senderId) {
        msgs.add(new SupportMsg(msg, senderId));
    }

    class SupportMsg extends ReportMessage {
        public SupportMsg(String msg, int senderId) {
            super(msg, senderId, ReportType.Support);
        }

    }
}
