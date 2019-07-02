package Management;

import Model.Date;
import Model.Device;
import Model.User;
import config.Default_Val;
import setting.Setting;

public class Device_Managment {

    public static boolean remove_device(Device removement_device , Device user_device , User user){
        if(Setting.getToday().getTime() - user_device.getDevice_login().getTime() > Setting.minDateOfLogin){
            user.removeUserDevices(removement_device);
            return true;
        }else{
            showError(Default_Val.cantremovedevice.toString());
            return false;
        }

    }

    public static boolean add_device(Device added_device  , User user){
        if(user.getUserDevices().size()<=Setting.maxDevices){
            user.addUserDevices(added_device);
            return true;
        }else{
            showError(Default_Val.cantaddevice.toString());
            return false;
        }

    }




    public static void showError(String error){

    }
}
