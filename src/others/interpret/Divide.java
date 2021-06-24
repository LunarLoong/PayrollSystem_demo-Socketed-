package cn.edu.bnuz.interpret;

public class Divide implements IExpress{
    private IExpress expressLeft;
    private IExpress expressRight;

    public Divide(IExpress expressLeft, IExpress expressRight) {
        this.expressLeft = expressLeft;
        this.expressRight = expressRight;
    }

    @Override
    public double interpret(Context context) {
        return this.expressLeft.interpret(context)/this.expressRight.interpret(context);
    }
}
