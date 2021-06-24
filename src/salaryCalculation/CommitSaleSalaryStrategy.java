package salaryCalculation;


public class CommitSaleSalaryStrategy implements SalaryStrategy {
    private double basicSalary;
    final public double percent = 0.03;
    private double amount;

    public CommitSaleSalaryStrategy(){
        this.basicSalary = 0;
        this.amount = 0;
    }

    public CommitSaleSalaryStrategy(double basicSalary, double amount) {
        this.basicSalary = basicSalary;
        this.amount = amount;
    }

    @Override
    public double calculate() {
        return basicSalary + (amount * percent);
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}

