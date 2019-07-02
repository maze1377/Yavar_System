package Model;

public class Order {//todo need to complete!
    //private final Integer idOrder;
    private Date orderDate;
    private Document document;
    private User orderUser;
    private boolean isSuccessFull;

    public Order(Date orderDate, Document document, User orderUser, boolean isSuccessFull) {
        this.orderDate = orderDate;
        this.document = document;
        this.orderUser = orderUser;
        this.isSuccessFull = isSuccessFull;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public User getOrderUser() {
        return orderUser;
    }

    public void setOrderUser(User orderUser) {
        this.orderUser = orderUser;
    }

    public boolean isSuccessFull() {
        return isSuccessFull;
    }

    public void setSuccessFull(boolean successFull) {
        isSuccessFull = successFull;
    }
}
