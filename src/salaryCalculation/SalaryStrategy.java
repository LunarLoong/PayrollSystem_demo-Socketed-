package salaryCalculation;

import java.io.Serializable;

public interface SalaryStrategy extends Serializable {
    public abstract double calculate();
}
