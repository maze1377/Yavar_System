package Management;

import DB.Db_Handler;
import Model.Admin;
import Model.MessageType;
import Model.Report.AnswerableSingleMsg;
import Model.Report.ReportSingleMsg;
import Model.Report.ReportType;
import Model.Report.SupportMsg;
import Model.User;
import service.SendMassageManager;
import setting.Setting;

import java.util.Arrays;
import java.util.List;

public class AnsweringReportsManagement {
    public static List<ReportSingleMsg> getReports(ReportType type, boolean onlyUnanswered) {
        if (onlyUnanswered) {
            String queryUnansweredMessages = "";
            try {
                Db_Handler.getDatabaseHandler(Setting.Db_Table_name.Report).search(queryUnansweredMessages, Setting.Db_Table_name.Report, true);
                return null;
            } catch (Exception e) {
                return null;
            }
        } else {
            String queryAllMessages = "";
            Db_Handler.getDatabaseHandler(Setting.Db_Table_name.Report).search(queryAllMessages, Setting.Db_Table_name.Report, true);
            return null;
        }
    }

    public static List<SupportMsg> getSupportQueue() {
        String UnansweredChats = "";
        try {
            Db_Handler.getDatabaseHandler(Setting.Db_Table_name.Report).search(UnansweredChats, Setting.Db_Table_name.Support, true);
            return null;
        } catch (Exception e) {
            SendMassageManager messenger = new SendMassageManager();
            String noChatAvailable = "";
            messenger.ShowDialog(noChatAvailable);
            return null;
        }
    }

    public static void SendSupportMsg(Admin admin, User user, String msg) {
        SendMassageManager messenger = new SendMassageManager();
        messenger.sendMassageFromAdmin(msg, admin, Arrays.asList(user), MessageType.SupportChatMsg);
    }

    public static <T extends ReportSingleMsg & AnswerableSingleMsg> void answerMsg(T msg, String ans, Admin admin) {
        try {
            msg.answer(ans);
            Db_Handler.getDatabaseHandler(Setting.Db_Table_name.Report).updateReport(msg);
            SendMassageManager messenger = new SendMassageManager();
            messenger.sendMassageFromAdmin(ans, admin, Arrays.asList(msg.getSender()), MessageType.Admin);
        } catch (Exception e) {

        }
    }
}
