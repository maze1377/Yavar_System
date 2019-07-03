package Model;

import Management.AccountManagement;
import Model.Report.SupportMsg;
import service.PublicFunctions;
import service.Search;

import java.util.List;

public class User {
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
    private Date enterDate;
    private String creditCardNumber;
    private SupportMsg headMsg;
    private long credit;

    public User(List<Order> orderList, List<Document> myDocuments, String userName, String password, String firstName, String lastName, String nationalCode, String tel, String email, String field, String university, String certificate, Date enterDate, String creditCardNumber, long credit) {
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
    }

    public List<User> requestSearchAndFilterUser(String input, String field, String certificate, String university, String enterData, String enterYear) {
        boolean cancelSearch = false;
        List<User> resultUser = null;
        Search search = new Search();
        while(!cancelSearch) {
            List<User> users = search.searchUser(input);
            List<User> users1 = search.filterUser(field, certificate, university, enterData, enterYear);
            resultUser = PublicFunctions.intersection(users, users1);
            boolean searchAgain = true;
            while(searchAgain){
                List<User> users2 = search.searchUser(resultUser, input);
                List<User> users3 = search.filterUser(resultUser, field, certificate, university, enterData, enterYear);
                resultUser = PublicFunctions.intersection(users2, users3);
            }
        }
        return resultUser;
    }

    public List<Document> requestSearchAndFilterDocument(String input,String field, String certificate, String university, String course, long price, java.util.Date enterDate) {
        boolean cancelSearch = false;
        List<Document> resultDocument = null;
        Search search = new Search();
        while(!cancelSearch) {
            List<Document> documents = search.searchDocument(input);
            List<Document> documents1 = search.filterDocument(field, certificate, university, course, price, enterDate);
            resultDocument = PublicFunctions.intersection(documents, documents1);
            boolean searchAgain = true;
            while (searchAgain) {
                List<Document> documents2 = search.searchDocument(resultDocument, input);
                List<Document> documents3 = search.filterDocuments(resultDocument, field, certificate, university, course, price, enterDate);
                resultDocument = PublicFunctions.intersection(documents2, documents3);
            }
        }
        return resultDocument;
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

    public boolean equals(User user) {
        boolean isEquals = false;
        return isEquals;
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
}
