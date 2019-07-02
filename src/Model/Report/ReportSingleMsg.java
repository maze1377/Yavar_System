package Model.Report;

import Model.User;
import java.util.Date;

public abstract class ReportSingleMsg {

    private final ReportType type;
    private Date sendDate;
    private String msg;
    private int idMessage;
    private User sender;

    public ReportSingleMsg(ReportType type, String msg, int idMessage, User sender)  {
        this.type = type;
        this.msg = msg;
        this.idMessage = idMessage;
        this.sender = sender;
        this.sendDate = new Date();
    }

    public ReportSingleMsg(ReportType type, Date sendDate, String msg, int idMessage, User sender) {
        this.type = type;
        this.sendDate = sendDate;
        this.msg = msg;
        this.idMessage = idMessage;
        this.sender = sender;
    }

    public ReportType getType() {
        return type;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(int idMessage) {
        this.idMessage = idMessage;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }
}
