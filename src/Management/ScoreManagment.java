package Management;

import Model.Document;
import Model.Score;
import Model.User;

public class ScoreManagment {

    public  void addScore (Document document , Score score, User user){
        for(Score user_score : document.getScores()){
            if(score.getUser().equals(user_score.getUser())){
                document.updateScore(score);
                return;
            }
        }
        document.addScore(score);

    }


}
