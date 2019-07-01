package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Hashtag implements Serializable {//User can creat new Model.Hashtag
    private final String tag;//must be final ! list match with this tag!
    private List<Document> documentsOfTag;//may be User hashtree for make it unic!

    public Hashtag(String tag, List<Document> documentsOfTag) {//constructor for create model from Db
        this.tag = tag;
        this.documentsOfTag = documentsOfTag;
    }
    public Hashtag(String tag, Document document) {//constructor for create model for fist time
        this.tag = tag;
        this.documentsOfTag = new ArrayList<>();
        this.documentsOfTag.add(document);
    }
    public void AddDocument(Document document){

    }
    public void RemoveDocument(Document document){

    }//when remove Doc we must call this

    public String getTag() {
        return tag;
    }

    public List<Document> getDocumentsOfTag() {
        return documentsOfTag;
    }
}
