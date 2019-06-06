package Model.Report;

import java.util.Date;

public abstract class ReportMessage {
    private final long sendDate;
    private final String msg;
    private final int ReporterID;
    private final ReportType type;

    public ReportMessage(String msg, long sendTime, int ReporterID, ReportType type) {
        this.msg = msg;
        this.sendDate = sendTime;
        this.ReporterID = ReporterID;
        this.type = type;
    }

    public ReportMessage(String msg, int ReporterID, ReportType type) {
        this.msg = msg;
        this.ReporterID = ReporterID;
        this.type = type;
        this.sendDate = new Date().getTime();
    }

    public long getSendDate() {
        return sendDate;
    }

    public int getReporterID() {
        return this.ReporterID;
    }

    public String getMessage() {
        return msg;
    }

}
