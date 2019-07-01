package Management;

import DB.Db_Handler;
import Model.Date;
import Model.Document;
import Model.Order;
import Model.User;
import setting.Setting;

import java.util.List;

public class ProfileManagement {

    public static void editProfile(User user, User newUser){
        user.clone(newUser);
        Db_Handler.getDatabaseHandler(Setting.Db_Table_name.User).updateUser(user);
    }

    public static User createUser(List<Order> orderList, List<Document> myDocuments, String userName, String password, String firstName, String lastName, String nationalCode, String tel, String email, String field, String university, String certificate, Date enterDate, String creditCardNumber, long credit){
        return new User(orderList, myDocuments, userName, password, firstName, lastName, nationalCode, tel, email, field, university, certificate, enterDate, creditCardNumber, credit);
    }
}
