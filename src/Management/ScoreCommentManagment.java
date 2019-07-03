package Management;

import DB.Db_Handler;
import Model.*;
import Model.Block.BlockType;
import config.Default_Val;
import setting.Setting;

public class ScoreCommentManagment {


    public Score createscore(int scoreNum, User user, Date dateOfScore) {
        return new Score(scoreNum,user,dateOfScore);
    }

    public Comment createcomment(String body, Date dateOfComment, User user, String name, boolean show_name) {
        return new Comment(body,dateOfComment,user,name,show_name);
    }


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
        if(comment.getUser().negScoreExceeds(BlockType.Comment) != -1){ //// masdod nabodan
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
        }else{
            showError("you cant comment becuase you are block");
        }
    }

    public boolean removeComment(Comment comment , Document document){
        return document.removeComment(comment);
    }

    public boolean reportComment(ReportComment reportComment){

        if(reportComment.getDes().equals("")){
            return false;
        }
        if(reportComment.getUser().negScoreExceeds(BlockType.User) != -1){
            Db_Handler.getDatabaseHandler(Setting.Db_Table_name.ReportedComments).saveReportedComment(reportComment);
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
