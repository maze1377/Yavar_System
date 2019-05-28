package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Field implements Serializable {
    private final String field;//must be final ! list match with this tag!
    private List<Document> documentsOfField;//may be user hashtree for make it unic!

    public Field(String field, List<Document> documentsOfField) {//constructor for create model from Db
        this.field = field;
        this.documentsOfField = documentsOfField;
    }
    public Field(String field, Document document) {//constructor for create model for fist time
        this.field = field;
        this.documentsOfField = new ArrayList<>();
        this.documentsOfField.add(document);
    }
    public void AddDocument(Document document){

    }
    public void RemoveDocument(Document document){

    }//when remove Doc we must call this

    public String getField() {
        return field;
    }

    public List<Document> getDocumentsOfField() {
        return documentsOfField;
    }
}