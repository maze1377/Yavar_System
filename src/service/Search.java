package service;

import DB.Db_Handler;
import Model.Document;
import Model.User;
import setting.Setting;

import java.util.Date;
import java.util.List;

public class Search {

    public List<User> searchUser(String input){
        List<User> users =  Db_Handler.getDatabaseHandler(Setting.Db_Table_name.User).findUser(input);
        return users;
    }

    public List<User> searchUser(List<User> users, String input){
        List<User> results = null; //ToDo search
        return results;
    }

    public static List<Document> searchDocument(String input){
        List<Document> documents = Db_Handler.getDatabaseHandler(Setting.Db_Table_name.Document).findDocument(input);
        return documents;
    }

    public List<Document> searchDocument(List<Document> documents, String input){
        List<Document> results = null;
        return results;
    }

    public List<User> filterUser(String field, String certificate, String university, String enterData, String enterYear){
        List<User> users = Db_Handler.getDatabaseHandler(Setting.Db_Table_name.User).findUser(field, certificate, university, enterData, enterYear);
        return users;
    }

    public List<User> filterUser(List<User> users, String field, String certificate, String university, String enterData, String enterYear){
        List<User> result = null;
        return result;
    }

    public List<Document> filterDocument(String field, String certificate, String university, String course, long price, Date enterDate){
        List<Document> documents = Db_Handler.getDatabaseHandler(Setting.Db_Table_name.Document).findDocument(field, certificate, university, course);
        return documents;
    }

    public List<Document> filterDocuments(List<Document> documents, String field, String certificate, String university, String course, long price, Date enterDate){
        List<Document> result = null;
        return result;
    }

}
