package Management;

import Model.*;
import config.Default_Val;
import setting.Setting;

import java.util.ArrayList;

public class DeviceManagment {

    public  boolean remove_device(Device removement_device , Device user_device , User user){
        if(Setting.getToday().getTime() - user_device.getDevice_login().getTime() > Setting.minDateOfLogin){
            user.removeUserDevices(removement_device);
            return true;
        }else{
            showError(Default_Val.cantremovedevice.toString());
            return false;
        }

    }


    public ArrayList<Device> showDevices(User user){
        return user.getUserDevices();
    }


    public  boolean add_device(Device added_device  , User user){
        for(Device device : user.getUserDevices()){
            if(added_device.getMac_ip() == device.getMac_ip()){
                showError(Default_Val.deviceexist.toString());
                return false;
            }
        }
        if(user.getUserDevices().size()<=Setting.maxDevices){
            user.addUserDevices(added_device);
            return true;
        }else{
            showError(Default_Val.cantaddevice.toString());
            return false;
        }

    }




    public  void showError(String error){

    }

    public  boolean checkbody(String body){
        return  true;
    }
}
