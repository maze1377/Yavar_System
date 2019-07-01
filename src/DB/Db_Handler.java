package DB;

import Model.*;
import Model.Report.ReportMessage;
import setting.Setting;

import java.util.HashMap;
import java.util.List;
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

    public boolean validDatabase() {
        return database != null && database.isOpen();
    }

    //doc
    public boolean saveDocument(Document document) throws Db_Write_Ex {
        return true;
    }

    public boolean updateDocument(Document document) throws Db_Write_Ex {
        return true;
    }

    public boolean deleteDocument(Document document) {
        return true;
    }

    public List<Document> findDocument(String... arr) throws Db_NotFind_Ex {
        return null;
    }

    public Document findDocument(Integer idDoc) throws Db_NotFind_Ex {
        return null;
    }

    //admin
    public boolean saveAdmin(Admin admin) throws Db_Write_Ex {
        return true;
    }

    public boolean updateAdmin(Admin admin) throws Db_Write_Ex {
        return true;
    }

    public boolean deleteAdmin(Admin admin) {
        return true;
    }

    public List<Admin> findAdmin(String... arr) throws Db_NotFind_Ex {
        return null;
    }

    public Admin findAdmin(Integer idadmin) throws Db_NotFind_Ex {
        return null;
    }

    //user
    public boolean saveUser(User user) throws Db_Write_Ex {
        return true;
    }

    public boolean updateUser(User user) throws Db_Write_Ex {
        return true;
    }

    public boolean deleteUser(User user) {
        return true;
    }

    public List<User> findUser(String... arr) throws Db_NotFind_Ex {
        return null;
    }

    public User findUser(Integer idUser) throws Db_NotFind_Ex {
        return null;
    }

    public boolean updateBalance(User user, double Cost) throws Db_Write_Ex {
        return true;
    }

    public boolean buyDocument(User user, Document document) throws Db_Write_Ex {
        //every check done before call this!
        if (user.getCredit() > document.getCost()) {
            boolean sw = false;
            while (!sw) {
                sw = updateBalance(user, -document.getCost());
            }
            while (!sw) {
                sw = addDocumentToUser(user, document);
            }
            return true;
        }
        return true;
    }

    public boolean addDocumentToUser(User user, Document document) throws Db_Write_Ex {
        return true;
    }

    public boolean addMassageToUser(User user, Message message) throws Db_Write_Ex {
        return true;
    }

    public boolean blockUserForTime(User user, Date date) throws Db_Write_Ex {
        return true;
    }

    //Message
    public boolean saveMessage(Message message) throws Db_Write_Ex {
        return true;
    }

    public boolean deleteMessage(Message message) {
        return true;
    }

    //report
    public boolean saveReportMessage(ReportMessage reportMessage) throws Db_Write_Ex {
        return true;
    }

    //search for
    public List<Object> search(String q, Setting.Db_Table_name table_name, boolean withSnippets) {
        return null;
    }

    //


}
