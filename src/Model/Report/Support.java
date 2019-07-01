package Model.Report;

import java.util.ArrayList;

// For each User that has never used Support Section it will be created once and only
public class Support {
    private final ArrayList<ReportMessage> msgs;

    public Support() {
        this.msgs = new ArrayList<ReportMessage>();
    }

    public ArrayList<ReportMessage> getMsgs() {
        return msgs;
    }

    public void addMsg(String msg, int idMessage, int sender) {
        msgs.add(new SupportMsg(msg, idMessage, sender));
    }

    class SupportMsg extends ReportMessage {
        public SupportMsg(String msg, int idMessage, int sender) {
            super(ReportType.Support, msg, idMessage, sender);
        }
    }
}
