package staffManagement;

import staffManagement.Receipt;

import java.io.Serializable;
import java.util.List;

public class WorkTimeCard implements Serializable {
    private int time;
    private int unit;

    private double monthlySalary;

    final public double percent = 0.03;
    private List<Receipt> receipts;

    public WorkTimeCard(){
        this.time = -1;
        this.unit = -1;
        this.monthlySalary = -1;
        this.receipts = null;
    }

    public WorkTimeCard(int time, int unit, int salary,List<Receipt> receipts) {
        this.time = time;
        this.unit = unit;
        this.monthlySalary = salary;
        this.receipts = receipts;
    }

    public double getMount(){
        double sum = 0;
        for(Receipt each:this.receipts){
            sum += each.getAmount();
        }
        return sum;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public double getPercent() {
        return percent;
    }

    public List<Receipt> getRecipts() {
        return receipts;
    }

    public void setRecipts(List<Receipt> receipts) {
        this.receipts = receipts;
    }
}
