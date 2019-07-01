package Model.Report;

public class ReportComment extends ReportMessage {
    private final int forumID;
    private final int documentID;

    public ReportComment(String msg, int idMessage, int sender, int forumID, int documentID) {
        super(ReportType.Comment, msg, idMessage, sender);
        this.forumID = forumID;
        this.documentID = documentID;
    }

    public int getForumID() {
        return forumID;
    }

    public int getDocumentID() {
        return documentID;
    }
}
