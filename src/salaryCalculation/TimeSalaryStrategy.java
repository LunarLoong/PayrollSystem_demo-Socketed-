package salaryCalculation;


import java.io.Serializable;
import java.sql.Time;

public class TimeSalaryStrategy implements SalaryStrategy{
    private int time;
    private int unit;

    public TimeSalaryStrategy(){
        this.time = 0;
        this.unit = 0;
    }

    @Override
    public double calculate() {
        if(this.time > 8){
            return  (8 * this.unit) + (this.time - 8) * (this.unit * 1.5);
        }
        return this.time * this.unit;
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
}

