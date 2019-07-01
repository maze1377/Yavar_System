package Management;

import Model.User;

public class AccountManagement {

    public static boolean addAccount(User user, long amount){
        boolean statusPay = bankPort(amount);
        if(statusPay == true){
            user.addCredit(amount);
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
