package Model;

public class Device {
   private Date device_login ;
   private String mac_ip;

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
}
