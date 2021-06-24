package cn.edu.bnuz.interpret;

public class Multiply implements IExpress {
    private IExpress expressLeft;
    private IExpress expressRight;

    public Multiply(IExpress expressLeft, IExpress expressRight) {
        this.expressLeft = expressLeft;
        this.expressRight = expressRight;
    }
    public double interpret(Context context){
        return this.expressLeft.interpret(context)*this.expressRight.interpret(context);
    }
}
