package DB;

public class Db_Handler {
    private static Db_Handler ourInstance = new Db_Handler();

    public static Db_Handler getInstance() {
        return ourInstance;
    }

    private Db_Handler() {}

    public Document findDocument(int id){
        return null;
    }
    public void saveDocument(Document document) throws Db_Write_Ex{

    }
    public void updateDocument(Document document) throws Db_Write_Ex{

    }
    public void DeleteDocument (Document document){

    }

}
