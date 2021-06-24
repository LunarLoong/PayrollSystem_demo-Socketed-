package staffManagement;

import salaryCalculation.TimeSalaryStrategy;


public class TimeEmployee extends Employee{
    private WorkTimeCard workTimeCard = new WorkTimeCard();
    private TimeSalaryStrategy salaryStrategy = new TimeSalaryStrategy();

    public TimeEmployee() {
        super("-1", "UnKnown", "UnKnown", "UnKnown", "UnKnown", "UnKnown");
    }

    public TimeEmployee(String EID, String name, String sex, String age, String phone, String address, int time, int unit) {
        super(EID, name, sex, age, phone, address);
        this.workTimeCard.setTime(time);
        this.workTimeCard.setUnit(unit);
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

    public TimeSalaryStrategy getSalaryStrategy() {
        return salaryStrategy;
    }

    private void setSalaryStrategy(TimeSalaryStrategy salaryStrategy) {
        this.salaryStrategy = salaryStrategy;
    }
}