package Model.Report;

import Model.Document;
import Model.User;

public class ReportComment extends ReportSingleMsg {
    private final int forumID;
    private final Document doc;

    public ReportComment(String msg, int idMessage, User sender, int forumID, Document doc) {
        super(ReportType.Comment, msg, idMessage, sender);
        this.forumID = forumID;
        this.doc = doc;
    }

    public int getForumID() {
        return forumID;
    }

    public Document getDocumentID() {
        return this.doc;
    }
}
