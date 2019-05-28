package DB;

import Model.Document;

public class Db_Handler {
    private static Db_Handler ourInstance = new Db_Handler();

    public static Db_Handler getInstance() {
        return ourInstance;
    }

    private Db_Handler() {}

    public void saveDocument(Document document) throws Db_Write_Ex{

    }
    public void updateDocument(Document document) throws Db_Write_Ex{

    }
    public void deleteDocument (Document document){

    }
    public void findDocument (String ... arr ){

    }
    public void findDocument (Integer idDoc){

    }
}
