package cn.edu.bnuz.interpret;

public class Power implements IExpress {
    private Variable variable;
    private Variable n;

    public Power(Variable variable,Variable n) {
        this.variable = variable;
        this.n=n;
    }

    @Override
    public double interpret(Context context) {
        return Math.pow(this.variable.interpret(context),this.n.interpret(context));
    }
}
