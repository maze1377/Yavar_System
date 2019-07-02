package service;

import DB.Db_Handler;
import Model.Document;
import Model.User;
import setting.Setting;

import java.util.List;

public class Search {

    public static List<User> searchUser(String input){
        List<User> users =  Db_Handler.getDatabaseHandler(Setting.Db_Table_name.User).findUser(input);
        return users;
    }

    public static List<Document> searchDocument(String input){
        List<Document> documents = Db_Handler.getDatabaseHandler(Setting.Db_Table_name.Document).findDocument(input);
        return documents;
    }

    public static List<User> filterUser(String... atr){
        List<User> users = Db_Handler.getDatabaseHandler(Setting.Db_Table_name.User).findUser(atr);
        return users;
    }

    public static List<Document> filterDocument(String... atr){
        List<Document> documents = Db_Handler.getDatabaseHandler(Setting.Db_Table_name.Document).findDocument(atr);
        return documents;
    }

}
