package Model;

public class Score {

    int scoreNum;
    User user;
    Date dateOfScore;


    public Score(int scoreNum, User user, Date dateOfScore) {
        this.scoreNum = scoreNum;
        this.user = user;
        this.dateOfScore = dateOfScore;
    }

    public Date getDateOfScore() {
        return dateOfScore;
    }

    public void setDateOfScore(Date dateOfScore) {
        this.dateOfScore = dateOfScore;
    }

    public int getScoreNum() {
        return scoreNum;
    }

    public void setScoreNum(int scoreNum) {
        this.scoreNum = scoreNum;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
