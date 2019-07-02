package Management;

import Model.*;
import config.Default_Val;

public class ScoreCommentManagment {

    public  void addScore (Document document , Score score, User user){
        for(Score user_score : document.getScores()){
            if(score.getUser().equals(user_score.getUser())){
                document.updateScore(score);
                return;
            }
        }
        document.addScore(score);

    }



    public void add_comment(Comment comment , Document document){
        if(true){ //// masdod nabodan
            if(comment.getBody().equals("")){
                showError(Default_Val.freecomment.toString());
            }else{
                if(checkbody(comment.getBody())){
                    document.addComment(comment);
                    showError(Default_Val.commentaccept.toString());
                }else{
                    showError(Default_Val.NotValidateMessage.toString());
                    //todo farakhani masdod kardan
                }
            }
        }
    }

    public boolean removeComment(Comment comment , Document document){
        return document.removeComment(comment);
    }

    public boolean reportComment(ReportComment reportComment){

        if(reportComment.getDes().equals("")){
            return false;
        }
        if(true){
            ///////
            return true;
        }else{
            showError(Default_Val.morereports.toString());
            return false;
            ///
        }

    }


    public  void showError(String error){

    }


    public  boolean checkbody(String body){
        return  true;
    }





}
