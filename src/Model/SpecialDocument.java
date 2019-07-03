package Model;

public class SpecialDocument {
    private Date startDate;

    private  Document document;
    private  int cost;
    private  int mounth;
    private boolean pay = false;

    public boolean isPay() {
        return pay;
    }

    public void setPay(boolean pay) {
        this.pay = pay;
    }

    public SpecialDocument(Date startDate, Document document, int cost, int mounth) {
        this.startDate = startDate;
        this.document = document;
        this.cost = cost;
        this.mounth = mounth;

    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getMounth() {
        return mounth;
    }

    public void setMounth(int mounth) {
        this.mounth = mounth;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }



    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }


}
