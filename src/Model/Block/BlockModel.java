package Model.Block;

import Model.Date;

public class BlockModel {
    private int negativePoint;
    private Date date;

    public BlockModel(int negativePoint, Date date) {
        this.negativePoint = negativePoint;
        this.date = date;
    }

    public int getNegativePoint() {
        return negativePoint;
    }

    public void setNegativePoint(int negativePoint) {
        this.negativePoint = negativePoint;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int increment(){
        return ++(this.negativePoint);
    }
}
