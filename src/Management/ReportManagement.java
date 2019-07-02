package Management;

import DB.Db_Handler;
import Model.MessageType;
import Model.Report.*;
import Model.User;
import config.Default_Val;
import service.SendMassageManager;
import setting.Setting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReportManagement {

    private ReportManagement() {
    }

    public static void createComment(String commentMsg, int idMessage, User sender, int forumID, int documentID) {
        SendMassageManager messenger = new SendMassageManager();
        try {
            ReportComment comment = new ReportComment(commentMsg, idMessage, sender, forumID, documentID);
            Db_Handler.getDatabaseHandler(Setting.Db_Table_name.Report).saveReportMessage(comment);
            if (Setting.curentState == Setting.stateLan.Fa)
                messenger.sendMassageFromSystem(Default_Val.CommentSuccessful.getPer(), Arrays.asList(new User[]{sender}), MessageType.System);
            else
                messenger.sendMassageFromSystem(Default_Val.CommentSuccessful.getEn(), Arrays.asList(new User[]{sender}), MessageType.System);
        } catch (Exception e) {
            if (Setting.curentState == Setting.stateLan.Fa)
                messenger.sendMassageFromSystem(Default_Val.CommentNotSuccessful.getPer(), Arrays.asList(new User[]{sender}), MessageType.System);
            else
                messenger.sendMassageFromSystem(Default_Val.CommentNotSuccessful.getEn(), Arrays.asList(new User[]{sender}), MessageType.System);
        }
    }

    public static void createReportUser(String msg, int idMessage, User sender, int reportedUserID) {
        SendMassageManager messenger = new SendMassageManager();
        try {
            ReportUser report = new ReportUser(msg, idMessage, sender, reportedUserID);
            Db_Handler.getDatabaseHandler(Setting.Db_Table_name.Report).saveReportMessage(report);
            if (Setting.curentState == Setting.stateLan.Fa)
                messenger.sendMassageFromSystem(Default_Val.ReportUserSuccessful.getPer(), Arrays.asList(new User[]{sender}), MessageType.System);
            else
                messenger.sendMassageFromSystem(Default_Val.ReportUserSuccessful.getEn(), Arrays.asList(new User[]{sender}), MessageType.System);
        } catch (Exception e) {
            if (Setting.curentState == Setting.stateLan.Fa)
                messenger.sendMassageFromSystem(Default_Val.ReportUserNotSuccessful.getPer(), Arrays.asList(new User[]{sender}), MessageType.System);
            else
                messenger.sendMassageFromSystem(Default_Val.ReportUserNotSuccessful.getEn(), Arrays.asList(new User[]{sender}), MessageType.System);
        }
    }

    public static void createReportDoc(String text, int idMessage, User sender, int reportedDocID) {
        SendMassageManager messenger = new SendMassageManager();
        try {
            ReportDoc report = new ReportDoc(text, idMessage, sender, reportedDocID);
            Db_Handler.getDatabaseHandler(Setting.Db_Table_name.Report).saveReportMessage(report);
            if (Setting.curentState == Setting.stateLan.Fa)
                messenger.sendMassageFromSystem(Default_Val.ReportDocSuccessful.getPer(), Arrays.asList(new User[]{sender}), MessageType.System);
            else
                messenger.sendMassageFromSystem(Default_Val.ReportDocSuccessful.getEn(), Arrays.asList(new User[]{sender}), MessageType.System);
        } catch (Exception e) {
            if (Setting.curentState == Setting.stateLan.Fa)
                messenger.sendMassageFromSystem(Default_Val.ReportDocNotSuccessful.getPer(), Arrays.asList(new User[]{sender}), MessageType.System);
            else
                messenger.sendMassageFromSystem(Default_Val.ReportDocNotSuccessful.getEn(), Arrays.asList(new User[]{sender}), MessageType.System);
        }
    }

    public static void createSuggestion(String text, int idMessage, User sender) {
        SendMassageManager messenger = new SendMassageManager();
        try {
            Suggestion sgst = new Suggestion(text, idMessage, sender);
            Db_Handler.getDatabaseHandler(Setting.Db_Table_name.Report).saveReportMessage(sgst);
            if (Setting.curentState == Setting.stateLan.Fa)
                messenger.sendMassageFromSystem(Default_Val.SuggestionSuccessful.getPer(), Arrays.asList(new User[]{sender}), MessageType.System);
            else
                messenger.sendMassageFromSystem(Default_Val.SuggestionSuccessful.getEn(), Arrays.asList(new User[]{sender}), MessageType.System);
        } catch (Exception e) {
            if (Setting.curentState == Setting.stateLan.Fa)
                messenger.sendMassageFromSystem(Default_Val.SuggestionNotSuccessful.getPer(), Arrays.asList(new User[]{sender}), MessageType.System);
            else
                messenger.sendMassageFromSystem(Default_Val.SuggestionNotSuccessful.getEn(), Arrays.asList(new User[]{sender}), MessageType.System);
        }
    }

    public static List<ReportMessage> getSupportMsgs(User user) {
        while (user.getHeadMsg() != null) {
            Db_Handler.getDatabaseHandler(Setting.Db_Table_name.Report).
                    search("", Setting.Db_Table_name.Report, true);
        }
        return null;
    }

    public static void addSupport(SupportMsg msgs, User user) {
        try {
            Db_Handler.getDatabaseHandler(Setting.Db_Table_name.Report).saveReportMessage(msgs);
        } catch (Exception e) {
            SendMassageManager messenger = new SendMassageManager();
            messenger.ShowDialog("Could not Send This Message Successfully.");
        }
    }

    public static List<ReportMessage> getReports(User user, ReportType type){
        List temp = null;
        switch (type){
            case Comment: temp = Db_Handler.getDatabaseHandler(Setting.Db_Table_name.Report).search("", Setting.Db_Table_name.Comment,true);break;
            case Suggestions: temp = Db_Handler.getDatabaseHandler(Setting.Db_Table_name.Report).search("", Setting.Db_Table_name.Suggestion,true);break;
            case Support: temp = Db_Handler.getDatabaseHandler(Setting.Db_Table_name.Report).search("", Setting.Db_Table_name.Support,true);break;
            case DocReport: temp = Db_Handler.getDatabaseHandler(Setting.Db_Table_name.Report).search("", Setting.Db_Table_name.DocReport,true);break;
            case UserReport: temp = Db_Handler.getDatabaseHandler(Setting.Db_Table_name.Report).search("", Setting.Db_Table_name.UserReport,true);break;
        }

        return (List<ReportMessage>)temp;
    }
}
