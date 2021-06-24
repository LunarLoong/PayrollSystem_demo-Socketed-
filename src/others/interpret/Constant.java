package cn.edu.bnuz.interpret;

public class Constant implements IExpress{
    private double value;
   public Constant(double value){
       this.value=value;
    }

    @Override
    public double interpret(Context context) {
        return value;
    }
}
