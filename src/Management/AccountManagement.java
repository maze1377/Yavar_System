package Management;

import DB.Db_Handler;
import Model.User;
import setting.Setting;

public class AccountManagement {

    public static boolean addAccount(User user, long amount){
        boolean statusPay = bankPort(amount);
        if(statusPay == true){
            user.addCredit(amount);
            Db_Handler.getDatabaseHandler(Setting.Db_Table_name.User).updateUser(user);
        }
        else{
            showError("payments error");
        }
        return true;
    }

    public static boolean bankPort(long amount){
        boolean statusPay = true;
        return statusPay;
    }

    public static void showError(String message){

    }
}
