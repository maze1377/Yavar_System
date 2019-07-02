package Model;

public class ReportComment {
    User user;
    Comment comment;
    String des;

    public ReportComment(User user, Comment comment, String des) {
        this.user = user;
        this.comment = comment;
        this.des = des;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
