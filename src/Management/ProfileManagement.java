package Management;

import DB.Db_Handler;
import Model.User;
import setting.Setting;

public class ProfileManagement {

    public static void editProfile(User user, User newUser){
        user.clone(newUser);
        Db_Handler.getDatabaseHandler(Setting.Db_Table_name.User).updateUser(user);
    }

    public static void createUser(){
        //User user = new User()
    }
}
