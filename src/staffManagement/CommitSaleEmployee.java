package staffManagement;


import salaryCalculation.CommitSaleSalaryStrategy;

public class CommitSaleEmployee extends Employee {
    private WorkTimeCard workTimeCard = new WorkTimeCard();
    private CommitSaleSalaryStrategy salaryStrategy = new CommitSaleSalaryStrategy();

    public CommitSaleEmployee() {
        super("-1", "UnKnown", "UnKnown", "UnKnown", "UnKnown", "UnKnown");
    }

    public CommitSaleEmployee(String EID, String name, String sex, String age, String phone, String address,double basicSalary,double amount) {
        super(EID, name, sex, age, phone, address);
        this.salaryStrategy.setBasicSalary(basicSalary);
        this.salaryStrategy.setAmount(amount);
    }

    @Override
    public double getSalary() {
        return this.salaryStrategy.calculate();
    }

    public WorkTimeCard getWorkTimeCard() {
        return workTimeCard;
    }

    public void setWorkTimeCard(WorkTimeCard workTimeCard) {
        this.workTimeCard = workTimeCard;
    }

    public CommitSaleSalaryStrategy getSalaryStrategy() {
        return salaryStrategy;
    }

    private void setSalaryStrategy(CommitSaleSalaryStrategy salaryStrategy) {
        this.salaryStrategy = salaryStrategy;
    }
}
