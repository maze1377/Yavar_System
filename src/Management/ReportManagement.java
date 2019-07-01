package Management;

import DB.Db_Handler;
import Model.Message;
import Model.Report.*;
import config.Default_Val;
import service.SendMassageManager;
import setting.Setting;

import java.util.ArrayList;
import java.util.List;

public class ReportManagement {

    private ReportManagement() {
    }

    public static void createComment(String commentMsg, int idMessage, int sender, int forumID, int documentID) {
        SendMassageManager messenger = new SendMassageManager();
        try {
            ReportComment comment = new ReportComment(commentMsg, idMessage, sender, forumID, documentID);
            Db_Handler.getDatabaseHandler(Setting.Db_Table_name.Report).saveReportMessage(comment);
            messenger.sendMassageFromSystem(Default_Val.CommentSuccessful, );
        } catch (Exception e) {
            messenger.sendMassageFromSystem(Default_Val.CommentNotSuccessful, );
        }
    }

    public static void createReportUser(String msg, int idMessage, int sender, int reportedUserID) {
        SendMassageManager messenger = new SendMassageManager();
        try {
            ReportUser report = new ReportUser(msg, idMessage, sender, reportedUserID);
            Db_Handler.getDatabaseHandler(Setting.Db_Table_name.Report).saveReportMessage(report);
            messenger.sendMassageFromSystem(Default_Val.ReportUserSuccessful, );
        } catch (Exception e) {
            messenger.sendMassageFromSystem(Default_Val.ReportUserNotSuccessful, );
        }
    }

    public static void createReportDoc(String text, int idMessage, int sender, int reportedDocID) {
        SendMassageManager messenger = new SendMassageManager();
        try {
            ReportDoc report = new ReportDoc(text, idMessage, sender, reportedDocID);
            Db_Handler.getDatabaseHandler(Setting.Db_Table_name.Report).saveReportMessage(report);
            messenger.sendMassageFromSystem(Default_Val.ReportDocSuccessful, );
        } catch (Exception e) {
            messenger.sendMassageFromSystem(Default_Val.ReportDocNotSuccessful, );
        }
    }

    public static void createSuggestion(String text, int idMessage, int sender) {
        SendMassageManager messenger = new SendMassageManager();
        try {
            Suggestion sgst = new Suggestion(text, idMessage, sender);
            Db_Handler.getDatabaseHandler(Setting.Db_Table_name.Report).saveReportMessage(sgst);
            messenger.sendMassageFromSystem(Default_Val.SuggestionSuccessful, );

        } catch (Exception e) {
            messenger.sendMassageFromSystem(Default_Val.SuggestionNotSuccessful, );

        }
    }

    public ArrayList<Support> getSupportMsgs(int userId) {
        Db_Handler.getDatabaseHandler(Setting.Db_Table_name.Report).
                search("", Setting.Db_Table_name.Report, true);
        return null;
    }

    public static void addSupport(ArrayList<Support> msgs, Support newMsg) {
        try {
            if(newMsg.);
            Db_Handler.getDatabaseHandler(Setting.Db_Table_name.Report).saveReportMessage(msgs);

        }catch (Exception e){

        }
    }

}
