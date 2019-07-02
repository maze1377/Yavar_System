package Management;

import DB.Db_Handler;
import Model.Admin;
import Model.Block.BlockType;
import Model.Block.Blockable;
import Model.Date;
import Model.MessageType;
import Model.User;
import service.SendMassageManager;
import service.TimerPoll;
import setting.Setting;

import java.util.LinkedList;

public class BlockManagement {
    private static TimerPoll timer = new TimerPoll(new LinkedList<>());

    public static void startTimer() {
        timer.addRunnable(new Date(), () -> {
            checkBlockDeadline();
            startTimer();
        });
    }

    public static void block(Blockable input, BlockType type, Admin admin) {
        if (input.block(type)){
            // set block time deadline
        }else{
            new SendMassageManager().sendMassageFromAdmin("",admin,null, MessageType.Warning);
        }
    }

    public static boolean isValidToLogin(User user) {
        return user.negScoreExceeds(BlockType.ConnectionLimit) != -1;
    }

    public static void checkBlockDeadline() {
        for (Blockable i : Db_Handler.getDatabaseHandler(Setting.Db_Table_name.User).findUser("All user Query")) {
            i.checkDeadline();
        }
    }
}
