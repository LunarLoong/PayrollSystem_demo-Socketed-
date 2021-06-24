package staffManagement;

import java.io.Serializable;

public class Receipt implements Serializable {
    private String date;
    private double amount;

    public Receipt(){

    }

    public Receipt(String date, int amount) {
        this.date = date;
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
