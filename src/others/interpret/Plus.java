package cn.edu.bnuz.interpret;

public class Plus implements IExpress{
    private IExpress expressLeft;
    private IExpress expressRight;

    public Plus(IExpress expressLeft, IExpress expressRight) {
        this.expressLeft = expressLeft;
        this.expressRight = expressRight;
    }

    @Override
    public double interpret(Context context) {
        return this.expressLeft.interpret(context)+this.expressRight.interpret(context);
    }
}
