package Model.Report;

import java.util.Date;

public abstract class ReportMessage {

    private final ReportType type;
    private final Date sendDate;
    private final String msg;
    private final int idMessage;
    private final int sender;

    public ReportMessage(ReportType type, String msg, int idMessage, int sender) {
        this.type = type;
        this.msg = msg;
        this.idMessage = idMessage;
        this.sender = sender;
        this.sendDate = new Date();
    }

    public ReportMessage(ReportType type, Date sendDate, String msg, int idMessage, int sender) {

        this.type = type;
        this.sendDate = sendDate;
        this.msg = msg;
        this.idMessage = idMessage;
        this.sender = sender;
    }

    public ReportType getType() {
        return type;
    }
}
