package Management;

import FileManager.WrapperFile;
import Model.Document;
import Model.MessageType;
import Model.User;
import config.Default_Val;
import service.SendMassageManager;

import java.util.ArrayList;
import java.util.List;

import static config.Default_Val.CantEditDoc;
import static service.SendMassageManager.ShowDialog;
import static shared_preferences.INPUT.*;

public class DocumentManager {
    public static boolean EditDocUser(User user, Document document) {
        if (!document.getPublisher().equals(user))
            ShowDialog(CantEditDoc.toString());
        String typeEdit = ReadinPut();
        if (typeEdit.contains("مشخصات اصلی")) {
            List<String> newInputs;
            boolean sw = false;
            while (!sw) {
                document.preview();
                newInputs = ReadinPuts();
                sw = Document.Validator(newInputs);
            }
            document.Update(newInputs);
            String detailsOfChange = ReadinPut();
            SendMassageManager.messegeToDocUsers(detailsOfChange, document, MessageType.Notification);
        } else if (typeEdit.contains("به روزرسانی ")) {
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
                }
            }
        } else {
            boolean sw = false;
            while (!sw) {
                WrapperFile newFiles = ReadInpusOfFile();
                Document.DocumentBuilder builder = new Document.DocumentBuilder(document);
                builder.setFiles(newFiles).getObj().preview();
                String stateOfInput = ReadinPut();
                sw = stateOfInput.contains("N");
                if (sw) {
                    List<String> itemsforchange = new ArrayList<>();
                    itemsforchange.add(newFiles.toString());
                    document.Update(itemsforchange);
                    SendMassageManager.messegeToDocUsers(Default_Val.DocUpdate.toString(), document, MessageType.Notification);
                }
            }

        }
    }

}
