package Model;

import java.util.ArrayList;

public class Admin {
    private final Integer IdAdmin;
    private String userName;
    private String password;
    private String firstName;
    private String LastName;
    private String tel;
    private String email;
    private ArrayList<Device> userDevices;
    private Date enterDate;
    private String creditCardNumber;

    public Admin(Integer idAdmin, String userName, String password, String firstName, String lastName, String tel, String email, ArrayList<Device> userDevices, Date enterDate, String creditCardNumber) {
        IdAdmin = idAdmin;
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        LastName = lastName;
        this.tel = tel;
        this.email = email;
        this.userDevices = userDevices;
        this.enterDate = enterDate;
        this.creditCardNumber = creditCardNumber;
    }

}
