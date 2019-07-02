package Model;

public class Score {

    int scoreNum;
    User user;

    public Score(int scoreNum, User user) {
        this.scoreNum = scoreNum;
        this.user = user;
        Date dateOfScore;
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
