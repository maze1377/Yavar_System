package Model.Report;

import Model.Message;
import Model.User;

import java.util.Date;

public abstract class ReportMessage extends Message {

    private final ReportType type;

    public ReportMessage(Date sendDate, String msg, int idMessage, User sender, User reciever, ReportType type) {
        super(sendDate, msg, idMessage, sender, reciever);
        this.type = type;
    }

    public ReportMessage(String msg, int idMessage, User sender, User reciever, ReportType type) {
        super(msg, idMessage, sender, reciever);
        this.type = type;
    }

    public ReportType getType() {
        return type;
    }
}
