package service;

import DB.Db_Handler;
import Model.*;
import config.Default_Val;
import setting.Setting;

import java.util.List;

import static service.Search.filterUser;
import static setting.Setting.genarateIdMessage;

public class SendMassageManager {
    List<String> blackList;

    //
    public void sendMassageFromSystem(String msg, List<User> recievers, MessageType type) {
        sendMassageFromAdmin(msg, Setting.SYSTEM, recievers, type);
    }

    //
    public void sendMassageFromAdmin(String msg, Admin admin, List<User> recievers, MessageType type) {
        if (ValidateMessage(msg)) {
            for (User user : recievers) {
                Message message = new Message(msg, genarateIdMessage(), admin, user);
                Db_Handler.getDatabaseHandler(Setting.Db_Table_name.Message).saveMessage(message);
            }
        } else {
            ShowDialog(Default_Val.NotValidateMessage.toString());
            String newmsg;//input
            sendMassageFromAdmin(newmsg, admin, recievers, type);
            return;
        }
    }

    //
    public static void messegeToDocUsers(String msg, Document document, MessageType type) {
        if (ValidateMessage(msg)) {
            switch (type) {
                case Admin:
                    Message message = new Message(msg, genarateIdMessage(), Setting.SYSTEM, document.getPublisher());
                    Db_Handler.getDatabaseHandler(Setting.Db_Table_name.Message).saveMessage(message);
                    break;
                case Notification://change by user
                    msg.contains(" from:" + document.getPublisher().getUserName());
                    List<User> targets = Db_Handler.getDatabaseHandler(Setting.Db_Table_name.User).findUser("*");
                    for (User user : targets) {
                        for (Order order : user.getOrderList()) {
                            if (order.isSuccessFull()) {
                                if (order.getDocument().equals(document)) {
                                    Message message2 = new Message(msg, genarateIdMessage(), Setting.SYSTEM, order.getOrderUser());
                                    Db_Handler.getDatabaseHandler(Setting.Db_Table_name.Message).saveMessage(message2);
                                    break;
                                }
                            }
                        }
                    }
                    break;
            }
        } else {
            ShowDialog(Default_Val.NotValidateMessage.toString());
            String newmsg;//input
            messegeToDocUsers(newmsg, document, type);
            return;
        }

    }

    public void sendMessageToUser(String msg, Admin admin, User user, MessageType type) {

    }

    //badane ersale be pm user sharh1:
    public void sendMessage(Admin admin) {
        MessageType messageType;//input!
        MessageAccessLevel accessLevel;//input!
        String massage;//input!

        switch (accessLevel) {
            case All:
                List<User> targets = Db_Handler.getDatabaseHandler(Setting.Db_Table_name.User).findUser("*");
                sendMassageFromAdmin(massage, admin, targets, messageType);
                break;
            case SpecialUsers:
                List<User> targets = filterUser();
                if (targets.size() < 1) {
                    ShowDialog(Default_Val.NotUserFind.toString());
                    return;
                }
                sendMassageFromAdmin(massage, admin, targets, messageType);
                break;
        }
    }

    public static void ShowDialog(String msg) {

    }

    public boolean ValidateMessage(String msg) {
        for (String xx : blackList) {
            if (msg.contains(xx))
                return false;
        }
        return true;
    }

}
