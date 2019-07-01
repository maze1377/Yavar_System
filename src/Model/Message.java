package Model;

import java.util.Date;

public abstract class Message {

    private final Date sendDate;
    private final String msg;
    private final int idMessage;
    private final Admin sender;
    private final User reciever;

    public Message(Date sendDate, String msg, int idMessage, Admin sender, User reciever) {
        this.sendDate = sendDate;
        this.msg = msg;
        this.idMessage = idMessage;
        this.sender = sender;
        this.reciever = reciever;
    }

    public Message(String msg, int idMessage, Admin sender, User reciever) {
        this.sendDate = new Date();
        this.msg = msg;
        this.idMessage = idMessage;
        this.sender = sender;
        this.reciever = reciever;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public String getMsg() {
        return msg;
    }

    public int getIdMessage() {
        return idMessage;
    }

    public Admin getSender() {
        return sender;
    }

    public User getReciever() {
        return reciever;
    }
}
