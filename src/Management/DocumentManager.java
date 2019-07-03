package Management;

import DB.Db_Handler;
import FileManager.WrapperFile;
import Model.*;
import config.Default_Val;
import service.SendMassageManager;
import setting.Setting;

import java.util.ArrayList;
import java.util.List;

import static Management.AccountManagement.addAccount;
import static config.Default_Val.CantEditDoc;
import static service.SendMassageManager.ShowDialog;
import static service.SendMassageManager.sendMassageFromAdmin;
import static shared_preferences.INPUT.*;

public class DocumentManager {
    public static boolean EditDocUser(User user, Document document) {
        if (!document.getPublisher().equals(user))
            ShowDialog(CantEditDoc.toString());
        String typeEdit = ReadinPut();
        if (typeEdit.contains("Details")) {
            List<String> newInputs = new ArrayList<>();
            boolean sw = false;
            while (!sw) {
                document.preview();
                newInputs = ReadinPuts();
                sw = Document.Validator(newInputs);
            }
            document.Update(newInputs);
            String detailsOfChange = ReadinPut();
            SendMassageManager.messegeToDocUsers(detailsOfChange, document, MessageType.Notification);
            return true;
        } else if (typeEdit.contains("update project ")) {
            boolean sw = false;
            while (!sw) {
                WrapperFile newFiles = ReadInpusOfFile();
                List<String> whereNeedUpdate = ReadinPuts();
                Document temp = document.ChangeForPrew(whereNeedUpdate, newFiles);
                temp.preview();
                String stateOfInput = ReadinPut();
                sw = stateOfInput.contains("N");
                if (sw) {
                    List<String> itemsforchange = new ArrayList<>();
                    itemsforchange.add(newFiles.toString());
                    itemsforchange.addAll(whereNeedUpdate);
                    document.Update(itemsforchange);
                    SendMassageManager.messegeToDocUsers(Default_Val.DocUpdate.toString(), document, MessageType.Notification);
                    return true;
                }
            }
        } else {
            boolean sw = false;
            while (!sw) {
                WrapperFile newFiles = ReadInpusOfFile();
                Document.DocumentBuilder builder = new Document.DocumentBuilder(document);
                builder.setFiles(newFiles).getObj().preview();
                String stateOfInput = ReadinPut();
                sw = stateOfInput.contains("Yes");
                if (sw) {
                    List<String> itemsforchange = new ArrayList<>();
                    itemsforchange.add(newFiles.toString());
                    document.Update(itemsforchange);
                    SendMassageManager.messegeToDocUsers(Default_Val.DocUpdate.toString(), document, MessageType.Notification);
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean EditDocMentAdmin(Admin admin, Document document) {
        List<Document> lastV = Db_Handler.getDatabaseHandler(Setting.Db_Table_name.templateOfDocs).findLastVertionOfDoc(document);
        for (Document last : lastV) {
            last.preview();
            String stateOfInput = ReadinPut();
            if (stateOfInput.contains("Yes")) {
                last.Update(null);
                SendMassageManager.messegeToDocUsers(Default_Val.EditedDoc.toString(), document, MessageType.Notification);
                return true;
            }
        }
        return false;
    }

    public static void DeleteDocumentAdmin(Admin admin, Document document) {
        if (document == null) {
            ShowDialog(Default_Val.NotFindDocument.toString());
            return;
        }
        List<User> targets = Db_Handler.getDatabaseHandler(Setting.Db_Table_name.User).findUser("*");
        for (User user : targets) {
            for (Order order : user.getOrderList()) {
                if (order.isSuccessFull()) {
                    if (order.getDocument().equals(document)) {
                        double cost = callDamageOfRemove(user, document);
                        addAccount(user, cost);
                        List<User> users = new ArrayList<>();
                        users.add(user);
                        sendMassageFromAdmin(Default_Val.fullDelet.toString(), admin, users, MessageType.Warning);
                        break;
                    }
                }
            }
        }
    }

    private static Double callDamageOfRemove(User user, Document document) {
        return null;
    }

    public static void DeleteDocumentUser(User user, Document document) {
        Date nowDate = new Date();
        if (document == null) {
            ShowDialog(Default_Val.NotFindDocument.toString());
            return;
        }
    }

    public static Document CreatDocument(User user) {
        return null;
    }

    public static boolean BuyDocument(User user, Document document) {
        return true;

    }
}
