package DB;

import Model.Document;
import Model.Message;
import Model.User;

public class Db_Handler {
    private static Db_Handler ourInstance = new Db_Handler();

    public static Db_Handler getInstance() {
        return ourInstance;
    }

    private Db_Handler() {}

    //doc
    public void saveDocument(Document document) throws Db_Write_Ex{

    }
    public void updateDocument(Document document) throws Db_Write_Ex{

    }
    public void deleteDocument (Document document){

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

    public void addMassageToUser(User user, Document document) throws Db_Write_Ex {

    }

    //Message
    public void saveMessage(Message message) throws Db_Write_Ex {

    }

    public void deleteMessage(Message message) {

    }
    //


}
