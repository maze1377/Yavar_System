package Model;

import Management.AccountManagement;
import Model.Block.BlockType;
import Model.Block.BlockTypeException;
import Model.Block.Blockable;
import Model.Report.SupportMsg;
import setting.Setting;

import java.util.ArrayList;
import java.util.List;

public class User implements Blockable {
    //private final Integer idUser;
    private List<Order> orderList;
    private List<Document> myDocuments;
    private String userName;
    private String password;
    private String firstName;
    private String LastName;
    private String nationalCode;
    private String tel;
    private String email;
    private String field;
    private String university;
    private String certificate;
    private ArrayList<Device> userDevices;
    private Date enterDate;
    private String creditCardNumber;
    private SupportMsg headMsg;
    private long credit;
    private int commentBlock;
    private int userBlock;
    private int docBlock;
    private int connectionLimitBlock;

    public User(List<Order> orderList, List<Document> myDocuments, String userName, String password, String firstName, String lastName, String nationalCode, String tel, String email, String field, String university, String certificate, Date enterDate, String creditCardNumber, SupportMsg headMsg, long credit) {
        this.orderList = orderList;
        this.myDocuments = myDocuments;
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        LastName = lastName;
        this.nationalCode = nationalCode;
        this.tel = tel;
        this.email = email;
        this.field = field;
        this.university = university;
        this.certificate = certificate;
        this.enterDate = enterDate;
        this.creditCardNumber = creditCardNumber;
        this.credit = credit;
        userDevices = new ArrayList<>();
    }


    public ArrayList<Device> getUserDevices() {
        return userDevices;
    }


    public void addUserDevices(Device device) {
        userDevices.add(device);
    }

    public boolean removeUserDevices(Device device) {
        for (int w = 0; w < userDevices.size(); w++) {
            if (device.getMac_ip() == userDevices.get(w).getMac_ip()) {
                userDevices.remove(w);
                return true;
            }
        }
        return false;

    }

    public void setUserDevices(ArrayList<Device> userDevices) {
        this.userDevices = userDevices;
    }

    public void requestAddCredit(long amount) {
        AccountManagement.addAccount(this, amount);
    }

    public void addCredit(long amount) {
        credit += amount;
    }

    public void requestWithdraw(long amount) {
        AccountManagement.withdraw(this, amount);
    }

    public void withdraw(long amount) {
        credit -= amount;
    }

    public void clone(User user) {

    }

    public boolean hasCreditCard() {
        return !creditCardNumber.isEmpty();
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public List<Document> getMyDocuments() {
        return myDocuments;
    }

    public void setMyDocuments(List<Document> myDocuments) {
        this.myDocuments = myDocuments;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    public Date getEnterDate() {
        return enterDate;
    }

    public void setEnterDate(Date enterDate) {
        this.enterDate = enterDate;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public long getCredit() {
        return credit;
    }

    public void setCredit(long credit) {
        this.credit = credit;
    }

    public SupportMsg getHeadMsg() {
        return headMsg;
    }

    public void setHeadMsg(SupportMsg headMsg) {
        this.headMsg = headMsg;
    }

    public int getCommentBlock() {
        return commentBlock;
    }

    public void setCommentBlock(int commentBlock) {
        this.commentBlock = commentBlock;
    }

    public int getUserBlock() {
        return userBlock;
    }

    public void setUserBlock(int userBlock) {
        this.userBlock = userBlock;
    }

    public int getDocBlock() {
        return docBlock;
    }

    public void setDocBlock(int docBlock) {
        this.docBlock = docBlock;
    }

    public int getConnectionLimitBlock() {
        return connectionLimitBlock;
    }

    public void setConnectionLimitBlock(int connectionLimitBlock) {
        this.connectionLimitBlock = connectionLimitBlock;
    }

    @Override
    public int negScoreExceeds(BlockType type) throws BlockTypeException {
        switch (type) {
            case Comment:
                if (this.commentBlock >= Setting.BlockMinimumDefault.Comment.getVal()) return -1;
                else return this.commentBlock;
            case ConnectionLimit:
                if (this.connectionLimitBlock >= Setting.BlockMinimumDefault.ConnectionLimit.getVal()) return -1;
                else return this.connectionLimitBlock;
            case Document:
                if (this.docBlock >= Setting.BlockMinimumDefault.Document.getVal()) return -1;
                else return this.docBlock;
            case User:
                if (this.userBlock >= Setting.BlockMinimumDefault.User.getVal()) return -1;
                else return this.userBlock;
            default:
                throw new BlockTypeException(type);
        }
    }

    @Override
    public boolean block(BlockType type) throws BlockTypeException {
        switch (type) {
            case User: this.userBlock++;
                break;
            case Comment: this.commentBlock++;
                break;
            case Document: this.docBlock++;
                break;
            case ConnectionLimit: this.connectionLimitBlock++;
                break;
            default:
                throw new BlockTypeException(type);
        }
        if (this.negScoreExceeds(type) == -1) return false;
        return true;
    }
}
