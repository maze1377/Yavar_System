package Model;

import Model.Block.BlockModel;
import Model.Block.BlockType;
import Model.Block.BlockTypeException;
import Model.Block.Blockable;

public class Device implements Blockable{
   private Date device_login ;
   private String mac_ip;
   private BlockModel blockModel;

    public Date getDevice_login() {
        return device_login;
    }

    public void setDevice_login(Date device_login) {
        this.device_login = device_login;
    }

    public String getMac_ip() {
        return mac_ip;
    }

    public void setMac_ip(String mac_ip) {
        this.mac_ip = mac_ip;
    }

    public Device(Date device_login, String mac_ip) {
        this.device_login = device_login;
        this.mac_ip = mac_ip;
    }

    @Override
    public int negScoreExceeds(BlockType type) throws BlockTypeException {
        return 0;
    }

    @Override
    public boolean block(BlockType type) throws BlockTypeException {
        return false;
    }

    @Override
    public void checkDeadline() {

    }
}
