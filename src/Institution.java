import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Institution implements Serializable {//user can creat new Institution
    private final String institution;//must be final ! list match with this tag!
    private List<Document> documentsOfInstitution;//may be user hashtree for make it unic!

    public Institution(String institution, List<Document> documentsOfInstitution) {//constructor for create model from Db
        this.institution = institution;
        this.documentsOfInstitution = documentsOfInstitution;
    }

    public Institution(String institution, Document document) {//constructor for create model for fist time
        this.institution = institution;
        this.documentsOfInstitution = new ArrayList<>();
        this.documentsOfInstitution.add(document);
    }

    public void AddDocument(Document document) {

    }

    public void RemoveDocument(Document document) {

    }//when remove Doc we must call this

    public String getInstitution() {
        return institution;
    }

    public List<Document> getDocumentsOfInstitution() {
        return documentsOfInstitution;
    }
}
