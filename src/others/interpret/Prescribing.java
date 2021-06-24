package cn.edu.bnuz.interpret;

public class Prescribing implements IExpress{
    private Variable variable;

    public Prescribing(Variable variable) {
        this.variable = variable;
    }

    @Override
    public double interpret(Context context) {
        return Math.sqrt(this.variable.interpret(context));
    }
}
