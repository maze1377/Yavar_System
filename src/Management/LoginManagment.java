package Management;

import DB.Db_Handler;
import Model.Date;
import Model.Device;
import Model.User;
import setting.Setting;

import java.util.List;

public class LoginManagment {
    public User login(String username , String password , boolean savepass, String mac_ip , Date logindate){
        List<User> users =  Db_Handler.getDatabaseHandler(Setting.Db_Table_name.User).findUser(username);
        if(users.size()==0){
            showerror("یوزر نیم شما در سیستم موجود نمی باشد");
            return null;
        }else{
            if(users.get(0).getPassword().equals(password)){
                User logineduser= users.get(0);
                if(true){
                    if(logineduser.getUserDevices().size()<Setting.maxDevices){
                            showerror("خوش امدید");
                            if(savepass){
                             savepassword(username,password);
                            }
                            logineduser.addUserDevices(new Device(logindate,mac_ip));
                            return logineduser;
                            }else{
                        showerror("تعداد دستگاه های ورودی به حداکثر تعداد رسید است.");
                        return null;
                    }
                }else{
                    showerror("sg");
                    return null;
                }
            }else{
                showerror("پسوورد اشتباه");
                return null;
            }
        }
    }

    public void exitUser(Device device,User user){
        deletsavepassword();
                user.removeUserDevices(device);



    }
   private void showerror(String message){

   }
   public void savepassword(String username,String password){

   }

    public void deletsavepassword(){

    }
}
