package Model;

public class Comment {
    String body;
    Date dateOfComment;
    User user;

    public Comment(String body, Date dateOfComment, User user) {
        this.body = body;
        this.dateOfComment = dateOfComment;
        this.user = user;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getDateOfComment() {
        return dateOfComment;
    }

    public void setDateOfComment(Date dateOfComment) {
        this.dateOfComment = dateOfComment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
