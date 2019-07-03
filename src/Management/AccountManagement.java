package Management;

import DB.Db_Handler;
import Model.Date;
import Model.Document;
import Model.Order;
import Model.User;
import setting.Setting;

import java.util.List;

public class AccountManagement {

    public static boolean withdraw(User user, long amount){
        if(user.hasCreditCard()){
            if(user.getCredit() > amount + Setting.minCredit) {
                if(bankPortWithdraw(amount)) {
                    user.withdraw(amount);
                    return true;
                }
                else{
                    showError("payment error");
                    return false;
                }
            }
            else{
                showError("not enough credit");
                return false;
            }
        }
        else{
            List<Order> orderList = null;
            List<Document> myDocuments = null;
            String userName = null;
            String password = null;
            String firstName = null;
            String lastName = null;
            String nationalCode = null;
            String tel = null;
            String email = null;
            String field = null;
            String university = null;
            String certificate = null;
            Date enterDate = null;
            String creditCardNumber = null;
            long credit = 0;
            ProfileManagement.editProfile(user, new User(orderList, myDocuments, userName, password, firstName, lastName, nationalCode, tel, email, field, university, certificate, enterDate, creditCardNumber, credit));
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
