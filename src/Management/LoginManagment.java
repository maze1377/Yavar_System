package Management;

import DB.Db_Handler;
import Model.Block.BlockType;
import Model.Date;
import Model.Device;
import Model.User;
import setting.Setting;

import java.util.List;

public class LoginManagment {
    public User login(String username, String password, boolean savepass, String mac_ip, Date logindate) {
        List<User> users = Db_Handler.getDatabaseHandler(Setting.Db_Table_name.User).findUser(username);
        if (users.size() == 0) {
            showerror("cant find user name");
            Device device = new Device(logindate , mac_ip);
            BlockManagement.block(device, BlockType.Device, null);

            return null;
        } else {
            if (users.get(0).getPassword().equals(password)) {
                User logineduser = users.get(0);
                if (users.get(0).negScoreExceeds(BlockType.Device) != -1) {
                    if (logineduser.getUserDevices().size() < Setting.maxDevices) {
                        showerror("wellcome");
                        if (savepass) {
                            savepassword(username, password);
                        }
                        logineduser.addUserDevices(new Device(logindate, mac_ip));
                        return logineduser;
                    } else {
                        showerror("max devices.");
                        return null;
                    }
                } else {

                    showerror(users.get(0).getUserBlock().getDate().toString());
                    return null;
                }
            } else {
                showerror("wrong password");
                users.get(0).getUserDevices().get(0).block(BlockType.Device);
                return null;
            }
        }
    }

    public void exitUser(Device device, User user) {
        deletsavepassword();
        user.removeUserDevices(device);


    }

    public void forgetPassword(boolean emailorphone, String email, int phone, String password, Device device) {
        if (emailorphone) {
            List<User> users = Db_Handler.getDatabaseHandler(Setting.Db_Table_name.User).findUser("email:" + email);
            if (checkrobot()) {
                if (users.size() == 0) {
                    showerror("cant find email");
                } else {
                    if (sendMessageToEmail(email)) {
                        users.get(0).setPassword(password);
                        sendNewPassToEmail(email);
                    } else {
                        BlockManagement.block(device,BlockType.Device,null);
                    }
                }
            } else {
                showerror("wrong number");
                BlockManagement.block(device,BlockType.Device,null);
            }
        } else {
            List<User> users = Db_Handler.getDatabaseHandler(Setting.Db_Table_name.User).findUser("phone:" + phone);
            if (checkrobot()) {
                if (users.size() == 0) {
                    showerror("cant find phone");
                } else {
                    if (sendMessageToPhone(phone)) {
                        users.get(0).setPassword(password);
                        sendNewPassToPhone(phone);
                    } else {
                        BlockManagement.block(device, BlockType.Device, null);
                    }
                }
            } else {
                showerror("wrong password");
                BlockManagement.block(device, BlockType.Device, null);
            }
        }
    }


    private boolean sendMessageToEmail(String email) {
        return true;
    }

    private boolean sendMessageToPhone(int phone) {
        return true;
    }

    private void sendNewPassToPhone(int phone) {

    }

    private void sendNewPassToEmail(String email) {

    }

    private boolean checkrobot() {
        return true;
    }

    private void showerror(String message) {

    }

    public void savepassword(String username, String password) {

    }

    public void deletsavepassword() {

    }
}
