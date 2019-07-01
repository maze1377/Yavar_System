package DB;

import Model.Date;
import Model.Document;
import Model.Message;
import Model.User;
import setting.Setting;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Db_Handler {
    private static Map<String, Db_Handler> databaseMap = new HashMap<>();//Db_Connection_Poll
    private Database database = null;

    private Db_Handler(String databaseName) throws Db_Cant_Create_Ex {
        String base;
    }

    public static synchronized Db_Handler getDatabaseHandler(String databaseName) {
        Db_Handler handler = databaseMap.get(databaseName);
        if (handler == null) {
            handler = new Db_Handler(databaseName);
            databaseMap.put(databaseName, handler);
        }
        return handler;
    }

    //doc
    public void saveDocument(Document document) throws Db_Write_Ex {

    }

    public void updateDocument(Document document) throws Db_Write_Ex {

    }

    public void deleteDocument(Document document) {

    }

    public void findDocument(String... arr) throws Db_NotFind_Ex {

    }

    public void findDocument(Integer idDoc) throws Db_NotFind_Ex {

    }

    //user
    public void saveUser(User user) throws Db_Write_Ex {

    }

    public void updateUser(User user) throws Db_Write_Ex {

    }

    public void deleteUser(User user) {

    }

    public void findUser(String... arr) throws Db_NotFind_Ex {

    }

    public void findUser(Integer idUser) throws Db_NotFind_Ex {

    }

    public void updateBalance(User user, double Cost) throws Db_Write_Ex {

    }

    public void buyDocument(User user, Document document) throws Db_Write_Ex {

    }

    public void addDocumentToUser(User user, Document document) throws Db_Write_Ex {

    }

    public void addMassageToUser(User user, Message message) throws Db_Write_Ex {

    }

    public void blockUserForTime(User user, Date date) throws Db_Write_Ex {

    }

    //Message
    public void saveMessage(Message message) throws Db_Write_Ex {

    }

    public void deleteMessage(Message message) {

    }

    //
    public Cursor search(String q, Setting.Db_Table_name table_name, boolean withSnippets) {
        return null;
    }
    //


}
