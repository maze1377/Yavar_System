package service;

import DB.Db_Handler;
import Model.*;
import config.Default_Val;
import setting.Setting;

import java.util.List;

public class SendMassageManager {
    List<String> blackList;

    //
    public void sendMassageFromSystem(String msg, List<User> recievers, MessageType type) {
        sendMassageFromAdmin(msg, Setting.SYSTEM, recievers, type);
    }

    //
    public void sendMassageFromAdmin(String msg, Admin admin, List<User> recieverId, MessageType type) {

    }

    //
    public void messegeToDocUsers(String msg, Document document) {

    }

    public void sendMessageToUser(String msg, Admin admin, User user, MessageType type) {

    }

    //badane ersale be pm user sharh1:
    public void sendMessage(Admin admin) {
        MessageType messageType;//input!
        MessageAccessLevel accessLevel;//input!
        String massage;//input!
        String filters;//input!

        switch (accessLevel) {
            case All:
                List<User> targets = Db_Handler.getDatabaseHandler(Setting.Db_Table_name.User).findUser("*");
                sendMassageFromAdmin(massage, admin, targets, messageType);
                break;
            case SpecialUsers:
                List<User> targets = Db_Handler.getDatabaseHandler(Setting.Db_Table_name.User).findUser(filters);
                if (targets.size() < 1) {
                    ShowDialog(Default_Val.NotUserFind.toString());
                    return;
                }
                sendMassageFromAdmin(massage, admin, targets, messageType);
                break;
        }
    }

    public void ShowDialog(String msg) {

    }

    public boolean ValidateMessage(String msg) {
        for (String xx : blackList) {
            if (msg.contains(xx))
                return false;
        }
        return true;
    }

}
