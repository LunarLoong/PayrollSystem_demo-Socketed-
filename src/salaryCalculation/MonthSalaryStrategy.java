package salaryCalculation;

public class MonthSalaryStrategy implements SalaryStrategy {
    private double monthlySalary;

    public MonthSalaryStrategy(){
        this.monthlySalary = 0;
    }

    @Override
    public double calculate() {
        return this.monthlySalary;
    }

    public double getMonthlySalary() {
        return this.monthlySalary;
    }

    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }
}
