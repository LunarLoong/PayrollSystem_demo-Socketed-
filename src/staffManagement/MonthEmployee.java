package staffManagement;

import salaryCalculation.MonthSalaryStrategy;

public class MonthEmployee extends Employee {
    private WorkTimeCard workTimeCard = new WorkTimeCard();
    private MonthSalaryStrategy salaryStrategy = new MonthSalaryStrategy();

    public MonthEmployee() {
        super("-1", "UnKnown", "UnKnown", "UnKnown", "UnKnown", "UnKnown");
    }

    public MonthEmployee(String EID, String name, String sex, String age, String phone, String address, double monthlySalary) {
        super(EID, name, sex, age, phone, address);
        this.workTimeCard.setMonthlySalary(monthlySalary);
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

    public MonthSalaryStrategy getSalaryStrategy() {
        return salaryStrategy;
    }

    private void setSalaryStrategy(MonthSalaryStrategy salaryStrategy) {
        this.salaryStrategy = salaryStrategy;
    }
}