package Management;

import DB.Db_Handler;
import Model.User;
import setting.Setting;

public class AccountManagement {

    public static boolean withdraw(User user, long amount){
        if(user.hasCreditCard()){
            if(user.getCredit() > amount + Setting.minCredit) {
                if(bankPortWithdraw(amount))
                    user.withdraw(amount);
                return true;
            }
        }
        else{

        }
        return false;
    }

    public static boolean addAccount(User user, long amount){
        boolean statusPay = bankPortDeposit(amount);
        if(statusPay == true){
            user.addCredit(amount);
            Db_Handler.getDatabaseHandler(Setting.Db_Table_name.User).updateUser(user);
        }
        else{
            showError("payments error");
        }
        return true;
    }

    public static boolean bankPortDeposit(long amount){
        // Todo Bank Port
        boolean statusPay = true;
        return statusPay;
    }

    public static boolean bankPortWithdraw(long amount){
        // Todo Bank Port
        boolean statusPay = true;
        return statusPay;
    }

    public static void showError(String message){
        // ToDo show error
    }


}
